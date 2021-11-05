package com.example.wordsapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.wordsapp.LetterAdapter.*

class LetterAdapter(private val letter: ArrayList<String>):
    RecyclerView.Adapter<LetterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.letter_adapter, parent, false)
        return LetterViewHolder(view)
    }

    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        holder.mletter.text = letter[position]
        holder.mletter.setOnClickListener {
            val context = holder.view.context
            val intent = Intent(context, WordActivity::class.java)
            intent.putExtra(WordActivity.LETTER, holder.mletter.text.toString())
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return  letter.size
    }

    class LetterViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val mletter:Button = view.findViewById(R.id.letter_button)
    }
}