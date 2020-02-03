package co.za.takeabyte.gradalot2020.promotions.viewmodel

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.za.takeabyte.gradalot2020.promotions.uimodel.UIModelPromotionItem

class ViewModelPromotions : ViewModel() {
    val promotions: MutableLiveData<List<UIModelPromotionItem>> = MutableLiveData()

    fun getPromotions() {
        object : CountDownTimer(5000, 1000) {
            override fun onFinish() {
                promotions.postValue(generateDummyData())
            }

            override fun onTick(millisUntilFinished: Long) {}
        }.start()
    }

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