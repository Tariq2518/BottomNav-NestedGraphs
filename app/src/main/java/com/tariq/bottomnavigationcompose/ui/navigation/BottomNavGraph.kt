package com.tariq.bottomnavigationcompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.tariq.bottomnavigationcompose.ui.screens.*

@Composable
fun BottomNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        route = Graph.HOME_GRAPH,
        startDestination = BottomBarScreens.Home.route
    ) {
        composable(route = BottomBarScreens.Home.route) {
            ScreenContent(name = BottomBarScreens.Home.route,
                onClick = {
                    navController.navigate(Graph.INFO_GRAPH)
                })
        }
        composable(route = BottomBarScreens.Profile.route) {
            ScreenContent(name = BottomBarScreens.Profile.route,
                onClick = {

                })
        }
        composable(route = BottomBarScreens.Settings.route) {
            ScreenContent(name = BottomBarScreens.Home.route,
                onClick = {

                })
        }

        infoNavGraph(navController = navController)


    }

}

fun NavGraphBuilder.infoNavGraph(
    navController: NavHostController
) {
    navigation(
        route = Graph.INFO_GRAPH,
        startDestination = InfoScreens.Info.route
    ) {
        composable(route = InfoScreens.Info.route) {
            ScreenContent(name = InfoScreens.Info.route) {

            }
        }
    }
}

sealed class InfoScreens(val route: String) {
    object Info : InfoScreens(route = "INFO")
}