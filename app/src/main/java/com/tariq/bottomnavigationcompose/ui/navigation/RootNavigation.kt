package com.tariq.bottomnavigationcompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tariq.bottomnavigationcompose.ui.screens.BottomBarScreens
import com.tariq.bottomnavigationcompose.ui.screens.HomeScreen
import com.tariq.bottomnavigationcompose.ui.screens.MainScreen


object Graph {
    const val ROOT_GRAPH = "root_graph"
    const val AUTH_GRAPH = "auth_graph"
    const val HOME_GRAPH = "home_graph"
    const val INFO_GRAPH = "info_graph"
}

@Composable
fun RootNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        route = Graph.ROOT_GRAPH,
        startDestination = Graph.AUTH_GRAPH
    ) {

        authNavGraph(navController = navController)
        composable(route = Graph.HOME_GRAPH) {
            MainScreen()
        }
    }
}