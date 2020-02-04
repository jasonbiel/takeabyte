package co.za.takeabyte.gradalot2020.deals

import co.za.takeabyte.gradalot2020.promotions.uimodel.UIModelPromotionItem

interface IDealsView {

    fun configureDealsContainer()

    fun renderContentItems(items: List<UIModelPromotionItem>)

}