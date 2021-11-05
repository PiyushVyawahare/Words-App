package com.example.wordsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WordActivity : AppCompatActivity() {

    private lateinit var wAdapter: WordAdapter


    companion object{
        const val LETTER = "letter"
        const val SEARCH_PREFIX = "https://www.google.com/search?q="
    }
    private val words = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word)

        val letterId = intent?.extras?.getString(LETTER).toString()

        wAdapter = WordAdapter(words)
        val wordsRecyclerView = findViewById<RecyclerView>(R.id.wordsRecyclerView)
        wordsRecyclerView.adapter = wAdapter
        wordsRecyclerView.layoutManager = LinearLayoutManager(this)
        fetchData(letterId)

        title = getString(R.string.detail_prefix) + " " + letterId
    }

    private fun fetchData(letterId: String) {
        var words1 = resources.getStringArray(R.array.words).toList()

        words1 = words1.filter { it.startsWith(letterId, ignoreCase = true) }.sorted()
        for(items in words1){
            words.add(items.toString())
        }
    }
}