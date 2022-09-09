package com.example.shoppinglist.domain

interface ShopListRepository {

    fun getShopList(): List<ShopItem>
    fun addShopItem(item: ShopItem)
    fun removeShopItem(item: ShopItem)
    fun editShopItem(item: ShopItem)
    fun getShopItem(itemId: Int): ShopItem
}