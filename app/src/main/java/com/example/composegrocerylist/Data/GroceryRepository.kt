package com.example.composegrocerylist.Data

class GroceryRepository(private val dao: GroceryItemDao) {
    suspend fun addGroceryItem(item: GroceryItem) {
        dao.insert(item)
    }

    suspend fun getAllGroceryItems(): List<GroceryItem> {
        return dao.getAllItems()
    }

    suspend fun deleteGroceryItem(itemId: Long) {
        dao.deleteItem(itemId)
    }

    suspend fun updateGroceryItem(item: GroceryItem) {
        dao.updateItem(item)
    }

}
