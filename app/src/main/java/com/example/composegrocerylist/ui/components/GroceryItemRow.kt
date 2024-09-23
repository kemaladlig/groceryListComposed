package com.example.composegrocerylist.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.composegrocerylist.Data.GroceryItem


@Composable
fun GroceryListItem(item: GroceryItem, onDelete: () -> Unit, onCheck: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Overline text if checked
        Text(
            text = item.name,
            textDecoration = if (item.checked) TextDecoration.LineThrough else null,
        )

        Checkbox(
            checked = item.checked,
            onCheckedChange = { checked ->
                val updatedItem = item.copy(checked = checked)
                onCheck(checked)
            }
        )

        Spacer(modifier = Modifier.weight(1f))

        IconButton(onClick = onDelete) {
            Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete Item")
        }
    }
}