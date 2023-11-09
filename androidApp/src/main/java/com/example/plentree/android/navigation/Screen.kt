package com.example.plentree.android.navigation

sealed class Screen (val route: String) {
    object HomeScreen : Screen("home_screen")
    object PostDetailsScreen : Screen("post_details")
    object TreesScreen : Screen("trees_screen")
    object ProfileScreen : Screen("profile_screen")
    object PlanterScreen : Screen("planter_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach {arg ->
                append("/$arg")
            }
        }
    }
}