package com.tariq.bottomnavigationcompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.tariq.bottomnavigationcompose.ui.screens.LoginScreen
import com.tariq.bottomnavigationcompose.ui.screens.ScreenContent


fun NavGraphBuilder.authNavGraph(
    navController: NavHostController
) {
    navigation(
        route = Graph.AUTH_GRAPH,
        startDestination = AuthScreens.Login.route
    ) {
        composable(route = AuthScreens.Login.route) {
            LoginScreen(onClick = {
                navController.popBackStack()
                navController.navigate(Graph.HOME_GRAPH)
            },
                onSignUpClick = { navController.navigate(AuthScreens.SignUp.route) },
                onForgetClick = {
                    navController.navigate(AuthScreens.FPASSWORD.route)
                })

        }
        composable(route = AuthScreens.SignUp.route) {
            ScreenContent(name = AuthScreens.SignUp.route) {

            }
        }
        composable(route = AuthScreens.FPASSWORD.route) {
            ScreenContent(name = AuthScreens.FPASSWORD.route) {

            }
        }
    }
}


sealed class AuthScreens(
    val route: String
) {
    object Login : AuthScreens(route = "LOGIN")
    object SignUp : AuthScreens(route = "SIGNUP")
    object FPASSWORD : AuthScreens(route = "FPASSWORD")
}