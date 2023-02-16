package com.tariq.bottomnavigationcompose.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.tariq.bottomnavigationcompose.ui.navigation.BottomNavGraph
import com.tariq.bottomnavigationcompose.ui.navigation.RootNavGraph

@Composable
fun MainScreen(navController: NavHostController = rememberNavController()) {

    Scaffold(
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) {
        Log.i("TAG", "MainScreen: $it")
        BottomNavGraph(navController = navController)
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreens.Home,
        BottomBarScreens.Profile,
        BottomBarScreens.Settings,
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val bottomBarScreens = screens.any { it.route == currentDestination?.route }

    if (bottomBarScreens) {
        BottomNavigation {
            screens.forEach { screens ->
                AddItem(
                    screens = screens,
                    currentDestination = currentDestination,
                    nacController = navController
                )
            }
        }
    }


}

@Composable
fun RowScope.AddItem(
    screens: BottomBarScreens,
    currentDestination: NavDestination?,
    nacController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(text = screens.title)
        },
        icon = {
            Icon(imageVector = screens.icon, contentDescription = "icon")
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screens.route
        } == true,
        onClick = {
            nacController.navigate(screens.route) {
                popUpTo(nacController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}