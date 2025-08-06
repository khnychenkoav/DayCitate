package com.example.daycitate

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.daycitate.data.AppDatabase
import com.example.daycitate.favorites.FavoritesAdapter
import com.example.daycitate.favorites.FavoritesViewModel
import com.example.daycitate.favorites.FavoritesViewModelFactory

class FavoritesActivity : AppCompatActivity() {

    private val viewModel: FavoritesViewModel by viewModels {
        FavoritesViewModelFactory(
            AppDatabase.getDatabase(this).quoteDao()
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_favorites)
        val backButton: Button = findViewById(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }
        val recyclerView: RecyclerView = findViewById(R.id.favoritesRecyclerView)
        val adapter = FavoritesAdapter()

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.allFavoriteQuotes.observe(this) { quotes ->
            quotes?.let {
                adapter.submitList(it)
            }
        }
    }
}