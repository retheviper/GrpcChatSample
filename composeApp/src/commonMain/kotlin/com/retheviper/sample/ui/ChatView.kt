package com.retheviper.sample.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType.Companion.KeyUp
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.unit.dp
import com.retheviper.sample.getPlatform

@Composable
fun ChatView() {
    var message by remember { mutableStateOf("") }
    var chatMessages by remember { mutableStateOf(listOf<Pair<String, String>>()) }
    val platform = getPlatform().name.let { if (it.contains("Java")) "Desktop" else it }

    fun sendMessage() {
        chatMessages = chatMessages + (platform to message)
        message = ""
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            items(chatMessages.size) { index ->
                val (sender, content) = chatMessages[index]
                Text(text = "[$sender]: $content", color = Color.Black)
            }
        }

        BasicTextField(
            value = message,
            onValueChange = { message = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
                .onKeyEvent { keyEvent ->
                    (keyEvent.type == KeyUp && keyEvent.key == Key.Enter).also {
                        if (it) {
                            sendMessage()
                        }
                    }
                },
            singleLine = true,
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .background(Color.LightGray)
                        .padding(8.dp)
                ) {
                    if (message.isEmpty()) {
                        Text(text = "Input message", color = Color.Gray)
                    }
                    innerTextField()
                }
            }
        )
        Button(
            onClick = ::sendMessage,
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "Send")
        }
    }

}

