package com.example.composegrocerylist.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composegrocerylist.Data.GroceryItem
import com.example.composegrocerylist.Data.GroceryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class GroceryViewModel(private val repository: GroceryRepository) : ViewModel() {

    private val _groceryItems = MutableStateFlow<List<GroceryItem>>(emptyList())
    val groceryItems: StateFlow<List<GroceryItem>> = _groceryItems.asStateFlow()

    init {
        fetchItems() // Load items on initialization
    }

    private fun fetchItems() {
        viewModelScope.launch {
            _groceryItems.value = repository.getAllGroceryItems()
        }
    }

    fun addGroceryItem(name: String) {
        val newItem = GroceryItem(name = name) // Create GroceryItem instance
        viewModelScope.launch {
            repository.addGroceryItem(newItem)
            fetchItems() // Refresh the list after adding
        }
    }

    fun deleteGroceryItem(itemId: Long) {
        viewModelScope.launch {
            repository.deleteGroceryItem(itemId)
            fetchItems() // Refresh the list after deletion
        }
    }

    fun setCheckedStatus(itemId: Int, isChecked: Boolean) {
        viewModelScope.launch {
            repository.updateCheckedStatus(itemId, isChecked)
        }
    }
}