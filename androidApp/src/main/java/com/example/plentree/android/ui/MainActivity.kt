package com.example.plentree.android.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.plentree.android.navigation.Navigation
import com.example.plentree.android.navigation.Screen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var selectedItemIndex by rememberSaveable {
                mutableStateOf(0)
            }
            val navController = rememberNavController()

            MyApplicationTheme {
                val items = listOf(
                    BottomNavigationItem(
                        title = "Home",
                        route = Screen.HomeScreen.route,
                        selectedIcon = Icons.Filled.Home,
                        unselectedIcon = Icons.Outlined.Home,
                        false,
                        10
                    ),
                    BottomNavigationItem(
                        title = "My Trees",
                        route = Screen.TreesScreen.route,
                        selectedIcon = Icons.Filled.Place,
                        unselectedIcon = Icons.Outlined.Place, false
                    ),
                    BottomNavigationItem(
                        title = "Profile",
                        Screen.ProfileScreen.route,
                        selectedIcon = Icons.Filled.Person,
                        unselectedIcon = Icons.Outlined.Person, true
                    ),
                )
                Scaffold(bottomBar = {
                    NavigationBar {
                        items.forEachIndexed { index, item ->
                            NavigationBarItem(
                                selected = selectedItemIndex == index,
                                onClick = {
                                    selectedItemIndex = index
                                    navController.navigate(item.route)
                                },
                                label = { Text(text = item.title) },
                                icon = {
                                    BadgedBox(badge = {
                                        if (item.badgeCount != null) {
                                            Badge {
                                                Text(text = item.badgeCount.toString())
                                            }
                                        } else if (item.hasNews) {
                                            Badge()
                                        }
                                    }) {
                                        Icon(
                                            imageVector = if (index == selectedItemIndex) item.selectedIcon else item.unselectedIcon,
                                            contentDescription = item.title
                                        )
                                    }
                                })
                        }
                    }
                }) {
                    Box(modifier = Modifier.padding(it)) {
                        Navigation(navController)
                    }
                }
            }
        }
    }
}

data class BottomNavigationItem(
    val title: String,
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }
}
