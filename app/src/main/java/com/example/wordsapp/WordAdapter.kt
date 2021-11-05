package com.example.wordsapp

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.wordsapp.WordAdapter.*

class WordAdapter(private val words: ArrayList<String>):
    RecyclerView.Adapter<WordViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.word_adapter, parent, false)
        return WordViewHolder(view)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val item = words[position]
        val context = holder.view.context
        holder.mWord.text = item
        holder.mWord.setOnClickListener {
            val queryUrl:Uri = Uri.parse("${WordActivity.SEARCH_PREFIX}${words[position]} meaning")
            val intent = Intent(Intent.ACTION_VIEW, queryUrl)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return words.size
    }

    class WordViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val mWord:Button = view.findViewById(R.id.word_button)
    }
}