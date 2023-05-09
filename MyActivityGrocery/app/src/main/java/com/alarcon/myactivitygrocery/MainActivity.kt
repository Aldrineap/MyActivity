package com.alarcon.myactivitygrocery

import android.content.Intent
import com.alarcon.myactivitygrocery.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity(), OnGroceryItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var counterTextView: TextView
    private lateinit var viewOrderButton: Button

    private val selectedItems = mutableListOf<GroceryItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        counterTextView = findViewById(R.id.counterTextView)
        viewOrderButton = findViewById(R.id.viewOrderButton)

        val groceryList = generateDummyGroceryItems() // Replace this with your actual list of grocery items
        val adapter = GroceryAdapter(groceryList, this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewOrderButton.setOnClickListener {
            val intent = Intent(this, SelectedItemsActivity::class.java)
            intent.putParcelableArrayListExtra("selectedItems", ArrayList(selectedItems))
            startActivity(intent)
        }
    }

    private fun generateDummyGroceryItems(): List<GroceryItem> {
        return listOf(
            GroceryItem(imageResourceId = R.drawable.ic_chix_hortdog, name = "Chix Hotdog", quantity = "1 kg", price = 10.0),
            GroceryItem(imageResourceId = R.drawable.ic_choco, name = "Chocolate Bar", quantity = "500 g", price = 5.0),
            GroceryItem(imageResourceId = R.drawable.ic_orange, name = "Orange Juice", quantity = "2 L", price = 15.0)
        )
    }

    override fun onGroceryItemClick(groceryItem: GroceryItem) {
        selectedItems.add(groceryItem)
        counterTextView.text = selectedItems.size.toString()
    }
}
