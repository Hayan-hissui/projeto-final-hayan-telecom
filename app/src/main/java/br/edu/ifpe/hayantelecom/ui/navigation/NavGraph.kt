/*
 * Hayan Telecom - App Android
 * Arquivo: NavGraph.kt
 * Responsável: Hayan / Interface e Navegação
 * Descrição: Grafo de navegação central do Jetpack Compose integrando todas as telas e ViewModels.
 */

package br.edu.ifpe.hayantelecom.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import br.edu.ifpe.hayantelecom.data.repository.HayanRepository
import br.edu.ifpe.hayantelecom.ui.components.HayanBottomBar
import br.edu.ifpe.hayantelecom.ui.components.HayanTopBar
import br.edu.ifpe.hayantelecom.ui.features.auth.AuthViewModel
import br.edu.ifpe.hayantelecom.ui.features.auth.CadastroScreen
import br.edu.ifpe.hayantelecom.ui.features.auth.LoginScreen
import br.edu.ifpe.hayantelecom.ui.features.home.HomeScreen
import br.edu.ifpe.hayantelecom.ui.features.home.HomeViewModel
import br.edu.ifpe.hayantelecom.ui.features.invoices.InvoiceDetailScreen
import br.edu.ifpe.hayantelecom.ui.features.invoices.InvoicesScreen
import br.edu.ifpe.hayantelecom.ui.features.invoices.InvoicesViewModel
import br.edu.ifpe.hayantelecom.ui.features.plan.PlanScreen
import br.edu.ifpe.hayantelecom.ui.features.plan.PlanViewModel
import br.edu.ifpe.hayantelecom.ui.features.profile.ProfileScreen
import br.edu.ifpe.hayantelecom.ui.features.profile.ProfileViewModel
import br.edu.ifpe.hayantelecom.ui.viewmodel.ViewModelFactory

@Composable
fun NavGraph(
    navController: NavHostController,
    repository: HayanRepository
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val factory = ViewModelFactory(repository)
    val snackbarHostState = remember { SnackbarHostState() }

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
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
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
                val authViewModel: AuthViewModel = viewModel(factory = factory)
                val loginSuccess by authViewModel.loginSuccess.collectAsState()
                val errorMessage by authViewModel.errorMessage.collectAsState()
                
                LaunchedEffect(loginSuccess) {
                    if (loginSuccess) {
                        navController.navigate(NavTarget.Home.route) {
                            popUpTo(NavTarget.Login.route) { inclusive = true }
                        }
                        authViewModel.resetStates()
                    }
                }

                LaunchedEffect(errorMessage) {
                    errorMessage?.let {
                        snackbarHostState.showSnackbar(it)
                        authViewModel.clearError()
                    }
                }

                LoginScreen(
                    viewModel = authViewModel,
                    onLoginSuccess = { /* Handled by LaunchedEffect */ },
                    onNavigateToCadastro = {
                        navController.navigate(NavTarget.Cadastro.route)
                    }
                )
            }

            composable(NavTarget.Cadastro.route) {
                val authViewModel: AuthViewModel = viewModel(factory = factory)
                val cadastroSuccess by authViewModel.cadastroSuccess.collectAsState()
                val errorMessage by authViewModel.errorMessage.collectAsState()

                LaunchedEffect(cadastroSuccess) {
                    if (cadastroSuccess) {
                        navController.navigate(NavTarget.Home.route) {
                            popUpTo(NavTarget.Cadastro.route) { inclusive = true }
                        }
                        authViewModel.resetStates()
                    }
                }

                LaunchedEffect(errorMessage) {
                    errorMessage?.let {
                        snackbarHostState.showSnackbar(it)
                        authViewModel.clearError()
                    }
                }

                CadastroScreen(
                    viewModel = authViewModel,
                    onCadastroSuccess = { /* Handled by LaunchedEffect */ },
                    onNavigateToLogin = {
                        navController.popBackStack()
                    }
                )
            }

            composable(NavTarget.Home.route) {
                val homeViewModel: HomeViewModel = viewModel(factory = factory)

                LaunchedEffect(Unit) {
                    homeViewModel.sincronizarDados()
                }

                HomeScreen(
                    viewModel = homeViewModel,
                    onVerBoletoClicked = { boletoId ->
                        navController.navigate(NavTarget.DetalheBoleto.createRoute(boletoId))
                    }
                )
            }

            composable(NavTarget.Plano.route) {
                val planViewModel: PlanViewModel = viewModel(factory = factory)
                val profileViewModel: ProfileViewModel = viewModel(factory = factory)

                PlanScreen(
                    planViewModel = planViewModel,
                    profileViewModel = profileViewModel
                )
            }

            composable(NavTarget.Boletos.route) {
                val invoicesViewModel: InvoicesViewModel = viewModel(factory = factory)

                LaunchedEffect(Unit) {
                    invoicesViewModel.atualizarCobrancas()
                }

                InvoicesScreen(
                    viewModel = invoicesViewModel,
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
                val invoicesViewModel: InvoicesViewModel = viewModel(factory = factory)

                InvoiceDetailScreen(
                    boletoId = boletoId,
                    viewModel = invoicesViewModel,
                    onNavigateBack = { navController.popBackStack() }
                )
            }

            composable(NavTarget.MinhaConta.route) {
                val profileViewModel: ProfileViewModel = viewModel(factory = factory)

                ProfileScreen(
                    viewModel = profileViewModel,
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
