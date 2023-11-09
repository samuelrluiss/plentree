package com.example.plentree.android.ui.home
import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavType
import com.google.gson.Gson
import kotlinx.parcelize.Parcelize

@Parcelize
data class Post(
    val id : Int,
    val planterId: Int?,
    val isSystemPost : Boolean,
    val text : String,
    val color: Int
): Parcelable

class AssetParamType : NavType<Post>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): Post? {
        return bundle.getParcelable(key)
    }

    override fun parseValue(value: String): Post {
        return Gson().fromJson(value, Post::class.java)
    }

    override fun put(bundle: Bundle, key: String, value: Post) {
        bundle.putParcelable(key, value)
    }
}