package com.example.daycitate

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.daycitate.data.AppDatabase
import com.example.daycitate.data.Quote
import com.example.daycitate.ui.quote.QuoteScreen
import com.example.daycitate.ui.quote.QuoteUiState
import com.example.daycitate.ui.quote.QuoteViewModel
import com.example.daycitate.ui.quote.QuoteViewModelFactory
import com.example.daycitate.ui.theme.DayCitateTheme

class MainActivity : ComponentActivity() {

    private val viewModel: QuoteViewModel by viewModels {
        QuoteViewModelFactory(
            AppDatabase.getDatabase(this).quoteDao()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DayCitateTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

                    QuoteScreen(
                        uiState = uiState,
                        onRefresh = { viewModel.loadNewQuote() },
                        onAddToFavorites = { viewModel.addToFavorites() },
                        onShowFavorites = {
                            val intent = Intent(this@MainActivity, FavoritesActivity::class.java)
                            startActivity(intent)
                        },
                        onNewQuote = {
                            val intent = Intent(this@MainActivity, NewQuoteActivity::class.java)
                            startActivity(intent)
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DayCitateTheme {
        QuoteScreen(uiState = QuoteUiState(quote = Quote("Hello World", "Android")), onRefresh = {}, onAddToFavorites = {}, onShowFavorites = {}, onNewQuote = {})
    }
}