package com.angelmascarell.intermodular2damc.core.routes

sealed class Routes(val route: String) {
    object  SignInScreen: Routes("signInScreen")
    object  SignUpScreen: Routes("signUpScreen")
    object  HomeScreen: Routes("homeScreen")
}