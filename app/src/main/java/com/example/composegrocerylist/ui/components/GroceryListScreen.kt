package com.example.composegrocerylist.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.example.composegrocerylist.ViewModel.GroceryViewModel


@Composable
fun GroceryListScreen(
    groceryViewModel: GroceryViewModel,
    modifier: Modifier = Modifier
) {
    var itemName by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            TextField(
                value = itemName,
                onValueChange = { newValue ->
                    itemName = newValue.capitalize()
                },
                label = { Text("Grocery Item") },
                modifier = Modifier.weight(1f)
            )

            Button(onClick = {
                if (itemName.isNotBlank()) {
                    groceryViewModel.addGroceryItem(itemName)
                    itemName = "" // Reset the input field
                }
            }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Item"
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        GroceryList(groceryViewModel)
    }
}

fun String.capitalize(): String {
    return this.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
}