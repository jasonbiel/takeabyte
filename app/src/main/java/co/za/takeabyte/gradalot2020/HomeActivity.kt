package co.za.takeabyte.gradalot2020

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import co.za.takeabyte.gradalot2020.deals.DealsActivity
import co.za.takeabyte.gradalot2020.productdescription.ProductDescriptionActivity
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
        Toast.makeText(this, "All Deals Selected", Toast.LENGTH_SHORT).show()

        val intent = Intent(this, DealsActivity::class.java)
        startActivity(intent)
    }

    private val onPromotionItemSelected: (UIModelPromotionItem) -> Unit = { model ->
        val intent = Intent(this, ProductDescriptionActivity::class.java)

        val pdpBundle = Bundle().apply {
            putString(ProductDescriptionActivity.PRODUCT_DESCRIPTION_TITLE, model.title)
            putInt(ProductDescriptionActivity.PRODUCT_DESCRIPTION_IMAGE, model.imageRes)
        }

        intent.putExtra(ProductDescriptionActivity.PRODUCT_DESCRIPTION_BUNDLE, pdpBundle)
        startActivity(intent)
    }
}