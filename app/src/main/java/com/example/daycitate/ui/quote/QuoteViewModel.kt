package com.example.daycitate.ui.quote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daycitate.data.Quote
import com.example.daycitate.data.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.IOException

data class QuoteUiState(
    val quote: Quote? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
)


class QuoteViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(QuoteUiState())

    val uiState: StateFlow<QuoteUiState> = _uiState.asStateFlow()

    init {
        loadNewQuote()
    }

    fun loadNewQuote() {
        viewModelScope.launch {
            _uiState.update { currentState ->
                currentState.copy(isLoading = true)
            }

            try {
                val newQuote = RetrofitInstance.api.getRandomQuote()
                _uiState.update { currentState ->
                    currentState.copy(isLoading = false, quote = newQuote)
                }
            } catch (e: IOException) {
                _uiState.update { currentState ->
                    currentState.copy(isLoading = false, error = "Network error. Please check your connection.")
                }
            } catch (e: Exception) {
                _uiState.update { currentState ->
                    currentState.copy(isLoading = false, error = "An unexpected error occurred.")
                }
            }
        }
    }
}