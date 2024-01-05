package com.angelmascarell.intermodular2damc.core.routes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.angelmascarell.intermodular2damc.home.presentation.HomeScreen

// Global variable
val LocalNavController = compositionLocalOf<NavHostController> { error("No NavController found!") }
@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    CompositionLocalProvider(LocalNavController provides navController) {
        NavHost(navController = navController, startDestination = Routes.HomeScreen.route) {
            composable(route = Routes.HomeScreen.route) {
                HomeScreen()
            }
            composable(route = Routes.SignInScreen.route) {
                //SignInScreen()
            }
            composable(route = Routes.SignUpScreen.route) {
                //SignUpScreen()
            }
        }
    }
}
