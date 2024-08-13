package com.retheviper.sample

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.retheviper.sample.ui.ChatView
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        ChatView()
    }
}