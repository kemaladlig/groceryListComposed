import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composegrocerylist.Data.GroceryItem

@Composable
fun GroceryItemRow(item: GroceryItem, onCheckedChange: (GroceryItem) -> Unit, onDelete: (GroceryItem) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Row for the checkbox and text
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = item.name,
                style = if (item.isChecked) {
                    MaterialTheme.typography.bodyMedium.copy(textDecoration = TextDecoration.LineThrough)
                } else {
                    MaterialTheme.typography.bodyMedium
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Checkbox(
                checked = item.isChecked,
                onCheckedChange = { onCheckedChange(item) }
            )
        }
        // Delete Button
        IconButton(onClick = { onDelete(item) }) {
            Icon(imageVector = Icons.Filled.Delete, contentDescription = "Delete")
        }
    }
}