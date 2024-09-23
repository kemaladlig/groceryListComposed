package com.example.composegrocerylist.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.example.composegrocerylist.ViewModel.GroceryViewModel


@Composable
fun GroceryListScreen(groceryViewModel: GroceryViewModel = viewModel()) {
    var itemName by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.Start
    ) {
        TextField(
            value = itemName,
            onValueChange = { itemName = it },
            label = { Text("Grocery Item") }
        )

        Button(onClick = {
            if (itemName.isNotBlank()) {
                groceryViewModel.addGroceryItem(itemName)
                itemName = "" // Clear input field
            }
        }) {
            Text("Add Item")
        }

        Spacer(modifier = Modifier.height(16.dp))

        GroceryList(groceryViewModel)
    }
}