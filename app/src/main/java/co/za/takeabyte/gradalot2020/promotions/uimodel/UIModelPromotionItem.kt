package co.za.takeabyte.gradalot2020.promotions.uimodel

import androidx.annotation.DrawableRes
import co.za.takeabyte.gradalot2020.R

data class UIModelPromotionItem(
    @DrawableRes val imageRes: Int = R.drawable.product_image,
    val title: String = String(),
    val price: Double = Double.MIN_VALUE
) {
    fun getDisplayPrice() = price.toString()
}