package com.example.plentree.android.ui.trees

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class TreesSreenViewModel @Inject constructor() {
    val items = (1..50).toList()

    fun getRandomIcon(): ImageVector {
        val iconsList = listOf(
            Icons.Default.Favorite,
            Icons.Default.Home,
            Icons.Default.Settings,
            Icons.Default.Favorite,
            Icons.Default.Build,
            Icons.Default.AccountCircle,
            Icons.Default.AddCircle,
            Icons.Default.Delete,
            Icons.Default.Warning,
            Icons.Default.Star,
        )
        return iconsList[Random.nextInt(iconsList.size)]
    }

    fun getRandomColor(): Color {
        val red = Random.nextInt(256)
        val green = Random.nextInt(256)
        val blue = Random.nextInt(256)
        return Color(red, green, blue)
    }
}

