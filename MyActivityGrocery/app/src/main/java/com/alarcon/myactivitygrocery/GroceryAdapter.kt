package com.alarcon.myactivitygrocery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alarcon.myactivitygrocery.databinding.ItemGroceryBinding

interface OnGroceryItemClickListener {
    fun onGroceryItemClick(groceryItem: GroceryItem)
}

class GroceryAdapter(
    private val items: List<GroceryItem>,
    private val onGroceryItemClickListener: OnGroceryItemClickListener
) : RecyclerView.Adapter<GroceryAdapter.GroceryViewHolder>() {

    inner class GroceryViewHolder(private val binding: ItemGroceryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: GroceryItem) {
            binding.apply {
                imageView.setImageResource(item.imageResourceId)
                textViewName.text = item.name
                textViewQuantity.text = item.quantity
                textViewPrice.text = item.price.toString()

                root.setOnClickListener { onGroceryItemClickListener.onGroceryItemClick(item) }
            }
        }
    }

    // Implement the onCreateViewHolder method
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        val binding = ItemGroceryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GroceryViewHolder(binding)
    }

    // Implement the onBindViewHolder method
    override fun onBindViewHolder(holder: GroceryViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    // Implement the getItemCount method
    override fun getItemCount(): Int {
        return items.size
    }
}
