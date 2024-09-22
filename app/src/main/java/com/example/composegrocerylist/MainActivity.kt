package com.example.composegrocerylist

import com.example.composegrocerylist.ui.components.GroceryListScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import com.example.composegrocerylist.Data.GroceryDatabase
import com.example.composegrocerylist.Data.GroceryRepository
import com.example.composegrocerylist.ViewModel.GroceryViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme{
                GroceryListScreen()
            }
        }
    }
}

