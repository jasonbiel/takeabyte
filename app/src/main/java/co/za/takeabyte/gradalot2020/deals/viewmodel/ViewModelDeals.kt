package co.za.takeabyte.gradalot2020.deals.viewmodel

import android.content.Context
import android.os.CountDownTimer
import androidx.lifecycle.ViewModel
import co.za.takeabyte.gradalot2020.deals.IDealsView
import co.za.takeabyte.gradalot2020.promotions.uimodel.UIModelPromotionItem
import co.za.takeabyte.gradalot2020.repository.IRepositoryPromotions
import co.za.takeabyte.gradalot2020.repository.impl.RepositoryPromotions

class ViewModelDeals : ViewModel() {

    private val repository: IRepositoryPromotions = RepositoryPromotions()

    private var context: Context? = null

    fun setContext(context: Context) {
        this.context = context
    }

    fun getPromotions() {
        object : CountDownTimer(1000, 1000) {
            override fun onFinish() {
                renderUI(repository.getPromotions())
            }

            override fun onTick(millisUntilFinished: Long) {}
        }.start()
    }

    fun renderUI(items: List<UIModelPromotionItem>) {
        val context = context
        if (context is IDealsView) {
            context.configureDealsContainer()
            context.renderContentItems(items)
        }
    }

}
