package com.example.shoppinglist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shoppinglist.domain.ShopItem
import com.example.shoppinglist.domain.ShopListRepository

object ShopListRepositoryImpl : ShopListRepository {

    private val shopList = mutableListOf<ShopItem>()
    private val shopListLD = MutableLiveData<List<ShopItem>>()
    private var autoIncrementId = 0

    init {
        for (i in 0 until 10) {
            val item = ShopItem("item $i", i, true)
            addShopItem(item)
        }
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLD
    }

    override fun addShopItem(item: ShopItem) {
        if (item.id == ShopItem.UNDEFINED_ID) {
            item.id = autoIncrementId++
        }
        shopList.add(item)
        updateShopList()
    }

    override fun removeShopItem(item: ShopItem) {
        shopList.remove(item)
        updateShopList()
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

    private fun updateShopList() {
        shopListLD.value = shopList.toList()
    }
}