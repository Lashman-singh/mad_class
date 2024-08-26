package np.com.lashman.easybot

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ChatPage(modifier: Modifier = Modifier, chatViewModel: ChatViewModel) {
    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ) {
        AppHeader()
        Spacer(modifier = Modifier.height(8.dp))
        MessageInput(onMessageSend = {
        })
    }
}

@Composable
fun MessageInput(onMessageSend : (String)-> Unit) {
    var message by remember { mutableStateOf("") }

    Row(
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = message,
            onValueChange = { message = it },
            modifier = Modifier.weight(1f),
            placeholder = { Text("Type your message...") }
        )
        IconButton(onClick = { sendMessage(message) }) { // Replace with your send message logic
            Icon(
                imageVector = Icons.Default.Send,
                contentDescription = "Send"
            )
        }
    }
}

@Composable
fun AppHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
    ) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = "Easy Bot",
            color = Color.White,
            fontSize = 22.sp
        )
    }
}

fun sendMessage(message: String) {
    // Implement your message sending logic here
    println("Message sent: $message")
}
