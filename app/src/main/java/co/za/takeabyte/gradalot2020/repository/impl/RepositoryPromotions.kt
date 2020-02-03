package co.za.takeabyte.gradalot2020.repository.impl

import co.za.takeabyte.gradalot2020.promotions.uimodel.UIModelPromotionItem
import co.za.takeabyte.gradalot2020.repository.IRepositoryPromotions

class RepositoryPromotions : IRepositoryPromotions {

    override fun getPromotions() = generateDummyData()

    private fun generateDummyData() = ArrayList<UIModelPromotionItem>().apply {
        add(
            UIModelPromotionItem(
                title = "GoldAir - 40cm Oscillating Fan - Black",
                price = 8999.00
            )
        )
        add(
            UIModelPromotionItem(
                title = "GoldAir - 40cm Oscillating Fan - Black",
                price = 8999.00
            )
        )
        add(
            UIModelPromotionItem(
                title = "GoldAir - 40cm Oscillating Fan - Black",
                price = 8999.00
            )
        )
        add(
            UIModelPromotionItem(
                title = "GoldAir - 40cm Oscillating Fan - Black",
                price = 8999.00
            )
        )
        add(
            UIModelPromotionItem(
                title = "GoldAir - 40cm Oscillating Fan - Black",
                price = 8999.00
            )
        )
        add(
            UIModelPromotionItem(
                title = "GoldAir - 40cm Oscillating Fan - Black",
                price = 8999.00
            )
        )
        add(
            UIModelPromotionItem(
                title = "GoldAir - 40cm Oscillating Fan - Black",
                price = 8999.00
            )
        )
        add(
            UIModelPromotionItem(
                title = "GoldAir - 40cm Oscillating Fan - Black",
                price = 8999.00
            )
        )
    }
}