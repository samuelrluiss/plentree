package com.example.plentree.android.ui.trees

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.plentree.android.navigation.Screen
import kotlin.random.Random

@Composable
fun TreesScreen(navController: NavController, treesSreenViewModel: TreesSreenViewModel) {
    Scaffold {
        LazyVerticalGrid(
            modifier = Modifier.padding(it).fillMaxSize(),
            columns = GridCells.Adaptive(minSize = 128.dp)
        ) {
            items(treesSreenViewModel.items.size) { item ->
                Card(
                    modifier = Modifier.clickable {
                        navController.navigate(Screen.PlanterScreen.withArgs(Random.nextInt().toString()))
                    }
                        .padding(16.dp)
                        .fillMaxWidth()
                        .aspectRatio(1f)
                ) {
                    Icon(
                        imageVector = treesSreenViewModel.getRandomIcon(),
                        contentDescription = "Random Icon",
                        tint = treesSreenViewModel.getRandomColor(), // Customize the icon color as needed
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    )
                }
            }
        }
    }
}