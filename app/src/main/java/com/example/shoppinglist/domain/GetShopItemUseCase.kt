package com.example.shoppinglist.domain

class GetShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun getItem(itemId: Int): ShopItem {
        return shopListRepository.getShopItem(itemId)
    }
}