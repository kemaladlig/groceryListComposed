import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composegrocerylist.ViewModel.GroceryViewModel
@OptIn(ExperimentalMaterial3Api::class)

@Composable @Preview
fun GroceryListScreen(viewModel: GroceryViewModel = viewModel()) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Grocery List") },
                modifier = Modifier.fillMaxWidth()
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = paddingValues.calculateTopPadding() + 8.dp,
                    bottom = 8.dp
                )
        ) {
            var newItemText by remember { mutableStateOf("") }

            // Input field and button to add new items
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    value = newItemText,
                    onValueChange = { newItemText = it },
                    placeholder = { Text("Enter item") },
                    modifier = Modifier.weight(1f)
                )
                Button(
                    onClick = {
                        if (newItemText.isNotEmpty()) {
                            viewModel.addItem(newItemText)
                            newItemText = ""
                        }
                    },
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    Icon(imageVector = Icons.Filled.Add, contentDescription = "Add", modifier = Modifier.size(24.dp))
                }
            }

            // Display the grocery list
            GroceryList(
                groceryList = viewModel.groceryList,
                onItemCheckedChange = { viewModel.toggleItemChecked(it) },
                onItemDelete = { viewModel.removeItem(it) }
            )
        }
    }
}