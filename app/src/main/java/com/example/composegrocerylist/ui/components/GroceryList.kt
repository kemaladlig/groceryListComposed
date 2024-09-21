import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.example.composegrocerylist.Data.GroceryItem

@Composable
fun GroceryList(
    groceryList: List<GroceryItem>,
    onItemCheckedChange: (GroceryItem) -> Unit,
    onItemDelete: (GroceryItem) -> Unit
) {
    LazyColumn {
        items(groceryList.size) { index ->
            val item = groceryList[index]
            GroceryItemRow(
                item = item,
                onCheckedChange = onItemCheckedChange,
                onDelete = onItemDelete
            )
        }
    }
}