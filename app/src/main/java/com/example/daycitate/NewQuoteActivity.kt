package com.example.daycitate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.daycitate.data.AppDatabase
import com.example.daycitate.data.FavoriteQuoteEntity
import com.example.daycitate.ui.theme.DayCitateTheme
import com.example.daycitate.ui.new_quote.NewQuoteScreen
import com.example.daycitate.ui.new_quote.NewQuoteViewModel
import com.example.daycitate.ui.new_quote.NewQuoteViewModelFactory

class NewQuoteActivity : ComponentActivity() {

    private val viewModel: NewQuoteViewModel by viewModels {
        NewQuoteViewModelFactory(
            AppDatabase.getDatabase(this).quoteDao()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            DayCitateTheme {
                NewQuoteScreen(
                    uiState = {},
                    onSubmitNewQuote = {
                        string1: String, string2: String ->
                        viewModel.newQuote(
                            FavoriteQuoteEntity(
                                quoteText = string1,
                                authorName = string2
                            )
                        )
                    }
                )
            }
        }
    }
}
