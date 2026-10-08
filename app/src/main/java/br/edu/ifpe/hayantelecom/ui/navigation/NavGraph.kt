/*
 * Hayan Telecom - App Android
 * Arquivo: NavGraph.kt
 * Responsável: Hayan / Interface e Navegação
 * Descrição: Grafo de navegação central do Jetpack Compose integrando todas as telas e repositório.
 */

package br.edu.ifpe.hayantelecom.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import br.edu.ifpe.hayantelecom.data.repository.HayanRepository
import br.edu.ifpe.hayantelecom.model.Cobranca
import br.edu.ifpe.hayantelecom.ui.components.HayanBottomBar
import br.edu.ifpe.hayantelecom.ui.components.HayanTopBar
import br.edu.ifpe.hayantelecom.ui.features.auth.CadastroScreen
import br.edu.ifpe.hayantelecom.ui.features.auth.LoginScreen
import br.edu.ifpe.hayantelecom.ui.features.home.HomeScreen
import br.edu.ifpe.hayantelecom.ui.features.invoices.InvoiceDetailScreen
import br.edu.ifpe.hayantelecom.ui.features.invoices.InvoicesScreen
import br.edu.ifpe.hayantelecom.ui.features.plan.PlanScreen
import br.edu.ifpe.hayantelecom.ui.features.profile.ProfileScreen
import kotlinx.coroutines.launch

@Composable
fun NavGraph(
    navController: NavHostController,
    repository: HayanRepository
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val cliente by repository.clienteFlow.collectAsState(initial = null)
    val plano by repository.planoFlow.collectAsState(initial = null)
    val cobrancas by repository.cobrancasFlow.collectAsState(initial = emptyList())
    val cobrancaPendente by repository.cobrancaPendenteFlow.collectAsState(initial = null)

    val coroutineScope = rememberCoroutineScope()

    val showBottomBar = currentRoute in listOf(
        NavTarget.Home.route,
        NavTarget.Plano.route,
        NavTarget.Boletos.route,
        NavTarget.MinhaConta.route
    )

    val topBarTitle = when (currentRoute) {
        NavTarget.Home.route -> "Início - Hayan Telecom"
        NavTarget.Plano.route -> "Meu Plano"
        NavTarget.Boletos.route -> "Boletos e Mensalidades"
        NavTarget.MinhaConta.route -> "Minha Conta"
        NavTarget.DetalheBoleto.route -> "Detalhes do Boleto"
        NavTarget.Cadastro.route -> "Cadastro"
        else -> "Hayan Telecom"
    }

    Scaffold(
        topBar = {
            if (currentRoute != NavTarget.Login.route && currentRoute != NavTarget.Cadastro.route) {
                HayanTopBar(
                    title = topBarTitle,
                    canNavigateBack = currentRoute?.startsWith("detalhe_boleto") == true,
                    onNavigateBack = { navController.popBackStack() }
                )
            }
        },
        bottomBar = {
            if (showBottomBar) {
                HayanBottomBar(navController = navController)
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = NavTarget.Login.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(NavTarget.Login.route) {
                LoginScreen(
                    onLoginSuccess = {
                        navController.navigate(NavTarget.Home.route) {
                            popUpTo(NavTarget.Login.route) { inclusive = true }
                        }
                    },
                    onNavigateToCadastro = {
                        navController.navigate(NavTarget.Cadastro.route)
                    }
                )
            }

            composable(NavTarget.Cadastro.route) {
                CadastroScreen(
                    onCadastroSuccess = {
                        navController.navigate(NavTarget.Home.route) {
                            popUpTo(NavTarget.Cadastro.route) { inclusive = true }
                        }
                    },
                    onNavigateToLogin = {
                        navController.popBackStack()
                    }
                )
            }

            composable(NavTarget.Home.route) {
                HomeScreen(
                    cliente = cliente,
                    plano = plano,
                    cobrancaPendente = cobrancaPendente,
                    onVerBoletoClicked = { boletoId ->
                        navController.navigate(NavTarget.DetalheBoleto.createRoute(boletoId))
                    }
                )
            }

            composable(NavTarget.Plano.route) {
                PlanScreen(
                    cliente = cliente,
                    plano = plano
                )
            }

            composable(NavTarget.Boletos.route) {
                InvoicesScreen(
                    cobrancas = cobrancas,
                    onCobrancaClicked = { boletoId ->
                        navController.navigate(NavTarget.DetalheBoleto.createRoute(boletoId))
                    }
                )
            }

            composable(
                route = NavTarget.DetalheBoleto.route,
                arguments = listOf(navArgument("boletoId") { type = NavType.StringType })
            ) { backStackEntry ->
                val boletoId = backStackEntry.arguments?.getString("boletoId") ?: ""
                val cobrancaState = produceState<Cobranca?>(initialValue = null, key1 = boletoId) {
                    value = repository.getCobrancaById(boletoId)
                }

                InvoiceDetailScreen(
                    cobranca = cobrancaState.value ?: cobrancas.find { it.id == boletoId },
                    onPagarClicked = { id ->
                        coroutineScope.launch {
                            repository.simularPagamento(id)
                        }
                    }
                )
            }

            composable(NavTarget.MinhaConta.route) {
                ProfileScreen(
                    cliente = cliente,
                    onLogoutClicked = {
                        navController.navigate(NavTarget.Login.route) {
                            popUpTo(0) { inclusive = true }
                        }
                    }
                )
            }
        }
    }
}
