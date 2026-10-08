/*
 * Hayan Telecom - App Android
 * Arquivo: NavTarget.kt
 * Responsável: Hayan / Interface e Navegação
 * Descrição: Definição das rotas de navegação do aplicativo e dos itens da barra inferior.
 */

package br.edu.ifpe.hayantelecom.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavTarget(val route: String) {
    object Login : NavTarget("login")
    object Cadastro : NavTarget("cadastro")
    object Home : NavTarget("home")
    object Plano : NavTarget("plano")
    object Boletos : NavTarget("boletos")
    object DetalheBoleto : NavTarget("detalhe_boleto/{boletoId}") {
        fun createRoute(boletoId: String) = "detalhe_boleto/$boletoId"
    }
    object MinhaConta : NavTarget("minha_conta")
}

sealed class BottomNavItem(val route: String, val title: String, val icon: ImageVector) {
    object Home : BottomNavItem(NavTarget.Home.route, "Início", Icons.Default.Home)
    object Plano : BottomNavItem(NavTarget.Plano.route, "Meu plano", Icons.Default.Info)
    object Boletos : BottomNavItem(NavTarget.Boletos.route, "Boletos", Icons.Default.List)
    object MinhaConta : BottomNavItem(NavTarget.MinhaConta.route, "Minha conta", Icons.Default.Person)
}

val bottomNavItems = listOf(
    BottomNavItem.Home,
    BottomNavItem.Plano,
    BottomNavItem.Boletos,
    BottomNavItem.MinhaConta
)
