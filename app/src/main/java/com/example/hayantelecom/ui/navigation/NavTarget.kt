package com.example.hayantelecom.ui.navigation

sealed class NavTarget(val route: String) {
    data object Home : NavTarget("home")
}
