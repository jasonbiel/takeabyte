package co.za.takeabyte.gradalot2020.repository

import co.za.takeabyte.gradalot2020.promotions.uimodel.UIModelPromotionItem

interface IRepositoryPromotions {
    fun getPromotions(): List<UIModelPromotionItem>
}