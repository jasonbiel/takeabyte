package co.za.takeabyte.gradalot2020

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import co.za.takeabyte.gradalot2020.promotions.uimodel.UIModelPromotionItem
import co.za.takeabyte.gradalot2020.promotions.viewmodel.ViewModelPromotions
import co.za.takeabyte.gradalot2020.promotions.ViewPromotionsCarousel
import kotlinx.android.synthetic.main.home_layout.*

class HomeActivity : AppCompatActivity() {

    private var viewModelPromotions: ViewModelPromotions? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_layout)

        addAndRenderPromotionsCarousel()
    }

    private fun addAndRenderPromotionsCarousel() {
        viewModelPromotions = ViewModelProvider(this)[ViewModelPromotions::class.java]
        val viewModel = viewModelPromotions
        if (viewModel != null) {
            val viewPromotionsCarousel = ViewPromotionsCarousel(
                homeRootView,
                viewModel,
                onAllDealsSelected,
                onPromotionItemSelected
            )

            homeRootView.addView(viewPromotionsCarousel.rootView)
        }
    }

    private val onAllDealsSelected: () -> Unit = {

    }

    private val onPromotionItemSelected: (UIModelPromotionItem) -> Unit = { model ->

    }
}