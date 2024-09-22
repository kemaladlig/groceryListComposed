package com.example.composegrocerylist.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.composegrocerylist.ViewModel.GroceryViewModel
import com.example.composegrocerylist.ui.components.GroceryListItem
import androidx.compose.foundation.lazy.items

@Composable
fun GroceryList(groceryViewModel: GroceryViewModel) {
    val groceryItems by groceryViewModel.groceryItems.collectAsState()

    LazyColumn {
        items(groceryItems) { item ->
            GroceryListItem(
                item = item,
                onDelete = { groceryViewModel.deleteGroceryItem(item.id) },
                onCheck = { checked ->
                    groceryViewModel.setCheckedStatus(item.id.toInt(), checked) // Update the item
                }
            )
        }
    }
}