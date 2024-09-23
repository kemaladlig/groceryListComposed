package com.example.composegrocerylist.Data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface GroceryItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: GroceryItem)

    @Query("SELECT * FROM grocery_items")
    suspend fun getAllItems(): List<GroceryItem>

    @Query("DELETE FROM grocery_items WHERE id = :itemId")
    suspend fun deleteItem(itemId: Long)

    @Update
    suspend fun updateItem(item: GroceryItem)

}