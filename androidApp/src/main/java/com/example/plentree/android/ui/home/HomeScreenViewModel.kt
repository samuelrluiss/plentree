package com.example.plentree.android.ui.home

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class HomeScreenViewModel @Inject constructor() {
    val posts = mutableListOf(
        Post(
            0,
            Random.nextInt(),
            false,
            "Here's my avocado tree, thank you John",
            randomColor().toArgb()
        ),
        Post(
            1,
            Random.nextInt(),
            true,
            "Kate's apple tree is now 6 months old",
            randomColor().toArgb()
        ),
        Post(2, null, true, "Sam just planted an Oak tree", randomColor().toArgb()),
        Post(
            3,
            null,
            true,
            "William has now reached the number of 50 trees with Pleentree",
            randomColor().toArgb()
        ),
        Post(
            4,
            null,
            true,
            "William has now planted trees in 15 different countries with Pleentree",
            randomColor().toArgb()
        ),
        Post(
            5,
            null,
            true,
            "My olive tree couldn't survive yesterdays's storm :(",
            randomColor().toArgb()
        )
    )
}


fun randomColor(): Color {
    val random = Random
    val red = random.nextInt(256)
    val green = random.nextInt(256)
    val blue = random.nextInt(256)
    return Color(red, green, blue)
}
