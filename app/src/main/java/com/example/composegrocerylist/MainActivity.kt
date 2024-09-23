package com.example.composegrocerylist

import com.example.composegrocerylist.ui.components.GroceryListScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composegrocerylist.Data.GroceryDatabase
import com.example.composegrocerylist.Data.GroceryRepository
import com.example.composegrocerylist.ViewModel.GroceryViewModel


class MainActivity : ComponentActivity() {
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
                GroceryListScreen(groceryViewModel)
            }
        }
    }
}

