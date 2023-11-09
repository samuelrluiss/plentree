package com.example.plentree.android.ui.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun ProfileScreen(navController: NavController) {
    Scaffold {
        Box(modifier = Modifier.padding(it)) {
            Text("Profile Screen")
        }
    }
}