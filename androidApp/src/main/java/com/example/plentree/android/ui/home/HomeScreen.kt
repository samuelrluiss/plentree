package com.example.plentree.android.ui.home

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.plentree.android.navigation.Screen
import com.google.gson.Gson

@Composable
fun HomeScreen(navController: NavHostController, homeScreenViewModel: HomeScreenViewModel) {
    Scaffold {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            items(homeScreenViewModel.posts) { post ->
                val postJson = Uri.encode(Gson().toJson(post))
                if (post.isSystemPost) {
                    SystemPostItem(post) {
                        navController.navigate(Screen.PostDetailsScreen.route + "/$postJson")
                    }
                } else {
                    UserPostItem(post) {
                        navController.navigate(Screen.PostDetailsScreen.route + "/$postJson")
                    }
                }
            }
        }
    }
}

@Composable
fun SystemPostItem(post: Post, onClickListener: () -> Unit) {
    Card(modifier = Modifier
        .background(Color.LightGray)
        .padding(horizontal = 16.dp, vertical = 8.dp)
        .clickable { onClickListener.invoke() }) {
        Column {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .background(Color(post.color)))
            Text(text = post.text, modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun UserPostItem(post: Post, onClickListener: () -> Unit) {
    Card(modifier = Modifier
        .background(Color.LightGray)
        .padding(horizontal = 16.dp, vertical = 8.dp)
        .clickable { onClickListener.invoke() }) {
        Column {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .background(Color(post.color)))
            Text(text = post.text, modifier = Modifier.padding(8.dp))
        }
    }
}
