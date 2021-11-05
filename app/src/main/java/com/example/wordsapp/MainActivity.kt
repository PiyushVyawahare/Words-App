package com.example.wordsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val letter = ArrayList<String>()
    private lateinit var mAdapter: LetterAdapter
    private var isLinearLayoutManager = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAdapter = LetterAdapter(letter)
        chooseLayout()
        fetchData()
    }

    private fun fetchData() {
        val list = ('A').rangeTo('Z').toList()
        for(item in list){
            letter.add(item.toString())
        }
    }

    private fun chooseLayout() {
        val lettersRecyclerView = findViewById<RecyclerView>(R.id.lettersRecyclerView)
        if (isLinearLayoutManager) {
            lettersRecyclerView.layoutManager = LinearLayoutManager(this)
        } else {
            lettersRecyclerView.layoutManager = GridLayoutManager(this, 4)
        }
        lettersRecyclerView.adapter = mAdapter
    }

    private fun setIcon(menuItem: MenuItem?) {
        if (menuItem == null)
            return
        menuItem.icon =
            if (isLinearLayoutManager)
                ContextCompat.getDrawable(this, R.drawable.ic_grid_layout)
            else ContextCompat.getDrawable(this, R.drawable.ic_linear_layout)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.layout_menu, menu)

        val layoutButton = menu?.findItem(R.id.action_switch_layout)
        setIcon(layoutButton)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_switch_layout -> {
                isLinearLayoutManager = !isLinearLayoutManager
                chooseLayout()
                setIcon(item)

                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}