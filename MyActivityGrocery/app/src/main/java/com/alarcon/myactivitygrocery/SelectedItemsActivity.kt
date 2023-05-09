package com.alarcon.myactivitygrocery

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class SelectedItemsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selected_items)

        recyclerView = findViewById(R.id.recyclerView)

        val selectedItems = (intent.getParcelableArrayListExtra<GroceryItem>("selectedItems") ?: emptyList<GroceryItem>()).toMutableList()

        val adapter = GroceryAdapter(selectedItems, object : OnGroceryItemClickListener {
            override fun onGroceryItemClick(groceryItem: GroceryItem) {
            }
        })

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {

            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val deletedItem = selectedItems[position]

                // Remove the item from the list and update the adapter
                selectedItems.removeAt(position)
                adapter.notifyItemRemoved(position)

                // Show a Snackbar to allow undoing the delete action
                Snackbar.make(recyclerView, "Item removed", Snackbar.LENGTH_LONG)
                    .setAction("Undo") {
                        // Undo delete action
                        selectedItems.add(position, deletedItem)
                        adapter.notifyItemInserted(position)
                    }.show()
            }
        }

        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }
}
