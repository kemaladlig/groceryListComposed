package com.example.composegrocerylist

import com.example.composegrocerylist.ui.components.GroceryListScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composegrocerylist.Data.GroceryDatabase
import com.example.composegrocerylist.Data.GroceryRepository
import com.example.composegrocerylist.ViewModel.GroceryViewModel


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            // Initialize GroceryViewModel using ViewModelProvider
            val groceryViewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return GroceryViewModel(
                        GroceryRepository(
                            GroceryDatabase.getDatabase(applicationContext).groceryItemDao()
                        )
                    ) as T
                }
            })[GroceryViewModel::class.java]

            MaterialTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text("Grocery List") },
                            actions = {
                                IconButton(onClick = { /*  */ }) {
                                    Icon(Icons.Default.Edit, contentDescription = "Liste")
                                }
                            }
                        )
                    }
                ) { paddingValues ->
                    GroceryListScreen(
                        groceryViewModel = groceryViewModel,
                        modifier = Modifier.padding(paddingValues)
                    )
                }
            }
        }
    }
}

