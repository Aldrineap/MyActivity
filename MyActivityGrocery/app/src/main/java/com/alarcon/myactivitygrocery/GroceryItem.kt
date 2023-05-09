package com.alarcon.myactivitygrocery


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GroceryItem(
    val name: String,
    val quantity: String,
    val price: Double,
    val imageResourceId: Int
) : Parcelable
