package co.za.takeabyte.gradalot2020.productdescription

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import co.za.takeabyte.gradalot2020.R
import co.za.takeabyte.gradalot2020.productdescription.viewmodel.ViewModelProductDescription
import kotlinx.android.synthetic.main.product_description_layout.*


class ProductDescriptionActivity : AppCompatActivity(), IProductDescriptionView {

    companion object {
        const val PRODUCT_DESCRIPTION_BUNDLE = "pdp_bundle"
        const val PRODUCT_DESCRIPTION_TITLE = "pdp_bundle_title"
        const val PRODUCT_DESCRIPTION_IMAGE = "pdp_bundle_image"
    }

    private var viewModelProductDescription: ViewModelProductDescription? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_description_layout)

        viewModelProductDescription =
            ViewModelProvider(this)[ViewModelProductDescription::class.java]

        lifecycle.addObserver(viewModelProductDescription!!)

        viewModelProductDescription?.setContext(this)
        viewModelProductDescription?.setDataBundle(intent.getBundleExtra(PRODUCT_DESCRIPTION_BUNDLE))
    }

    override fun renderImage(imageRes: Int) {
        pdpParentCarouselImage.setImageResource(imageRes)
    }

    override fun renderTitle(title: String) {
        pdpParentTitle.text = title
    }
}