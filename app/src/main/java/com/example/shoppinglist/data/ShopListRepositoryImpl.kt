package com.example.shoppinglist.data

import com.example.shoppinglist.domain.ShopItem
import com.example.shoppinglist.domain.ShopListRepository

object ShopListRepositoryImpl : ShopListRepository {

    private val shopList = mutableListOf<ShopItem>()
    private var autoIncrementId = 0

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }

    override fun addShopItem(item: ShopItem) {
        if (item.id == ShopItem.UNDEFINED_ID) {
            item.id = autoIncrementId++
        }
        shopList.add(item)
    }

    override fun removeShopItem(item: ShopItem) {
        shopList.remove(item)
    }

    override fun editShopItem(item: ShopItem) {
        val oldItem = getShopItem(item.id)
        shopList.remove(oldItem)
        addShopItem(item)
    }

    override fun getShopItem(itemId: Int): ShopItem {
        return shopList.find { it.id == itemId }
            ?: throw RuntimeException("element with id $itemId not found")
    }
}