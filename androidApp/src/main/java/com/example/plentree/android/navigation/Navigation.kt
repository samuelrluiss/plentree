package com.example.plentree.android.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.plentree.android.ui.home.AssetParamType
import com.example.plentree.android.ui.home.HomeScreen
import com.example.plentree.android.ui.home.HomeScreenViewModel
import com.example.plentree.android.ui.home.PostDetailsScreen
import com.example.plentree.android.ui.planter.PlanterScreen
import com.example.plentree.android.ui.profile.ProfileScreen
import com.example.plentree.android.ui.trees.TreesScreen
import com.example.plentree.android.ui.trees.TreesSreenViewModel

@Composable
fun Navigation(navController: NavHostController) {
    val homeScreenViewModel = HomeScreenViewModel()
    val treesSreenViewModel = TreesSreenViewModel()

    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController, homeScreenViewModel)
        }
        composable(route = Screen.TreesScreen.route) {
            TreesScreen(navController = navController, treesSreenViewModel)
        }
        composable(route = Screen.ProfileScreen.route) {
            ProfileScreen(navController = navController)
        }
        composable(
            route = Screen.PostDetailsScreen.route + "/{post}",
            arguments = listOf(
                navArgument("post") {
                    type = AssetParamType()
                    nullable = false
                }
            )
        ) { entry ->
            PostDetailsScreen(
                navController,
                post = entry.arguments?.getParcelable("post")
            )
        }
        composable(
            route = Screen.PlanterScreen.route + "/{planterId}",
            arguments = listOf(
                navArgument("planterId") {
                    type = NavType.IntType
                    nullable = false
                }
            )
        ) { entry ->
            PlanterScreen(
                navController, entry.arguments?.getInt("planterId")
            )
        }
    }
}