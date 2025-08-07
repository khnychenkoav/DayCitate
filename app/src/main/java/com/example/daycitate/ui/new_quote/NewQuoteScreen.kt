package com.example.daycitate.ui.new_quote

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import com.example.daycitate.data.FavoriteQuoteEntity
import com.example.daycitate.data.Quote

@Composable
fun NewQuoteScreen(
    uiState: () -> Unit,
    onSubmitNewQuote: (String, String) -> Unit,
) {
    val quoteText = remember { mutableStateOf("") }
    val authorName = remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        TextField(
            value = quoteText.value,
            onValueChange = { quoteText.value = it },
            label = { Text("Quote Text") },
            placeholder = { Text("Quote Text") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()

        )

        Spacer(modifier = Modifier.width(8.dp))

        TextField(
            value = authorName.value,
            onValueChange = { authorName.value = it },
            label = { Text("Author Name") },
            placeholder = { Text("Author Name") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
        )

        Button(onClick = { onSubmitNewQuote(quoteText.value , authorName.value) }) {
            Text("Submit")

        }
    }
}

