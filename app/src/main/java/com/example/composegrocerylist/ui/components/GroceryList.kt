package com.example.composegrocerylist.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.composegrocerylist.ViewModel.GroceryViewModel
import androidx.compose.foundation.lazy.items

@Composable
fun GroceryList(groceryViewModel: GroceryViewModel) {
    val groceryItems by groceryViewModel.groceryItems.collectAsState()

    LazyColumn {
        items(groceryItems) { item ->
            GroceryListItem(
                item = item,
                onDelete = { groceryViewModel.deleteGroceryItem(item.id) },
                onCheck = { checked -> // TODO:
                    //groceryViewModel.setCheckedStatus(item.id.toULong(), checked) // Update the item
                }
            )
        }
    }
}