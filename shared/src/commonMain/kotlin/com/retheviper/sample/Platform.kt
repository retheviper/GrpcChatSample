package com.retheviper.sample

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform