package com.example.plentree.android.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.plentree.android.navigation.Screen

@Composable
fun PostDetailsScreen(navController: NavHostController, post: Post?) {
    post?.let { post ->
        Box(
            contentAlignment = Alignment.Center, modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color(color = post.color ?: 0)
                )
                .padding(16.dp)
        ) {
            Text("$post.name")
            post.planterId?.let { planterId ->
                Button(modifier = Modifier.align(Alignment.BottomEnd),
                    onClick = {
                        navController.navigate(Screen.PlanterScreen.withArgs(planterId.toString()))
                    }) {
                    Row {
                        Icon(
                            imageVector = Icons.Filled.Face,
                            contentDescription = "Contact Planter"
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("Contact the Planter")
                    }
                }
            }
        }
    }
}