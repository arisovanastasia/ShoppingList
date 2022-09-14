package com.example.shoppinglist.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {

    fun getShopList(): LiveData<List<ShopItem>>
    fun addShopItem(item: ShopItem)
    fun removeShopItem(item: ShopItem)
    fun editShopItem(item: ShopItem)
    fun getShopItem(itemId: Int): ShopItem
}