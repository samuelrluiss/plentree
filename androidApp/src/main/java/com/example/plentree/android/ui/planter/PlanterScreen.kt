package com.example.plentree.android.ui.planter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.plentree.android.navigation.Screen

@Composable
fun PlanterScreen(navController: NavController, planterId: Int?) {
    Scaffold {
        Box(modifier = Modifier
            .background(color = Color.DarkGray).fillMaxWidth()
            .padding(it)) {

            IconButton(onClick = {
                navController.navigate(Screen.HomeScreen.route) {
                    popUpTo(Screen.HomeScreen.route) {
                        inclusive = true
                    }
                }
            }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "", tint = Color.Black)
            }
        }
    }
}