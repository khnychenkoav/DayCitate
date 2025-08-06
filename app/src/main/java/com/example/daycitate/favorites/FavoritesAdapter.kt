package com.example.daycitate.favorites

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.daycitate.R
import com.example.daycitate.data.FavoriteQuoteEntity

class FavoritesAdapter(
    private val onDeleteClicked: (FavoriteQuoteEntity) -> Unit
) : ListAdapter<FavoriteQuoteEntity, FavoritesAdapter.QuoteViewHolder>(QuoteDiffCallback()) {
    class QuoteViewHolder(
        itemView: View,
        private val onDeleteClicked: (FavoriteQuoteEntity) -> Unit
    ): RecyclerView.ViewHolder(itemView) {
        private val quoteTextView: TextView = itemView.findViewById(R.id.quoteTextView)
        private val authorTextView: TextView = itemView.findViewById(R.id.authorTextView)
        private val deleteButton: Button = itemView.findViewById(R.id.deleteButton)

        fun bind(quote: FavoriteQuoteEntity) {
            quoteTextView.text = "“${quote.quoteText}”"
            authorTextView.text = "- ${quote.authorName}"
            deleteButton.setOnClickListener {
                onDeleteClicked(quote)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_favorite_quote, parent, false)
        return QuoteViewHolder(view, onDeleteClicked)
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        val quote = getItem(position)
        holder.bind(quote)
    }

    class QuoteDiffCallback : DiffUtil.ItemCallback<FavoriteQuoteEntity>() {
        override fun areItemsTheSame(oldItem: FavoriteQuoteEntity, newItem: FavoriteQuoteEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: FavoriteQuoteEntity, newItem: FavoriteQuoteEntity): Boolean {
            return oldItem == newItem
        }

    }
}