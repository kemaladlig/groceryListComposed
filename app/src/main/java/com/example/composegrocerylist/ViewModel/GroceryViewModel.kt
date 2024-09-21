package com.example.composegrocerylist.ViewModel

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.composegrocerylist.Data.GroceryItem

class GroceryViewModel : ViewModel() {
    // Mutable list to hold grocery items
    private val _groceryList: SnapshotStateList<GroceryItem> = mutableStateListOf()

    // Public read-only access to the list
    val groceryList: List<GroceryItem> get() = _groceryList

    // Function to add a new item to the list
    fun addItem(itemName: String) {
        if (itemName.isNotEmpty()) {
            _groceryList.add(GroceryItem(itemName))
        }
    }

    // Function to toggle the checked state of an item
    fun toggleItemChecked(item: GroceryItem) {
        val index = _groceryList.indexOf(item)
        if (index != -1) {
            _groceryList[index] = item.copy(isChecked = !item.isChecked)
        }
    }

    // Function to remove an item from the list
    fun removeItem(item: GroceryItem) {
        _groceryList.remove(item)
    }
}