package com.example.plentree

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform