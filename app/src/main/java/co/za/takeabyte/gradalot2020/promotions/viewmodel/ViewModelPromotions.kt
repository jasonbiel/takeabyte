package co.za.takeabyte.gradalot2020.promotions.viewmodel

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.za.takeabyte.gradalot2020.promotions.uimodel.UIModelPromotionItem
import co.za.takeabyte.gradalot2020.repository.IRepositoryPromotions
import co.za.takeabyte.gradalot2020.repository.impl.RepositoryPromotions

class ViewModelPromotions : ViewModel() {
    private val repository: IRepositoryPromotions = RepositoryPromotions()
    val promotions: MutableLiveData<List<UIModelPromotionItem>> = MutableLiveData()

    fun getPromotions() {
        object : CountDownTimer(5000, 1000) {
            override fun onFinish() {
                promotions.postValue(repository.getPromotions())
            }

            override fun onTick(millisUntilFinished: Long) {}
        }.start()
    }

}