package com.example.composegrocerylist.Data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface GroceryItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: GroceryItem)

    @Query("SELECT * FROM grocery_items")
    suspend fun getAllItems(): List<GroceryItem>

    @Query("DELETE FROM grocery_items WHERE id = :itemId")
    suspend fun deleteItem(itemId: Long)

    @Query("UPDATE grocery_items SET checked = :isChecked WHERE id = :itemId")
    suspend fun updateCheckedStatus(itemId: Int, isChecked: Boolean)
}