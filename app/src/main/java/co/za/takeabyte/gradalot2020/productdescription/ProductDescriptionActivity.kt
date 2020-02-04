package co.za.takeabyte.gradalot2020.productdescription

import android.os.Bundle
import android.transition.TransitionInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.lifecycle.ViewModelProvider
import co.za.takeabyte.gradalot2020.R
import co.za.takeabyte.gradalot2020.productdescription.viewmodel.ViewModelProductDescription
import kotlinx.android.synthetic.main.product_description_layout.*

//TODO: Price information needs to be added.

class ProductDescriptionActivity : AppCompatActivity(), IProductDescriptionView {

    companion object {
        const val PRODUCT_DESCRIPTION_BUNDLE = "pdp_bundle"
        const val PRODUCT_DESCRIPTION_TITLE = "pdp_bundle_title"
        const val PRODUCT_DESCRIPTION_IMAGE = "pdp_bundle_image"
        const val PRODUCT_DESCRIPTION_TRANSITION_NAME = "pdp_bundle_transition_name"
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

        setupSharedElementTransition()
    }

    override fun renderImage(imageRes: Int) {
        pdpParentCarouselImage.setImageResource(imageRes)
    }

    override fun renderTitle(title: String) {
        pdpParentTitle.text = title
    }

    private fun setupSharedElementTransition() {
        val bundle = intent.getBundleExtra(PRODUCT_DESCRIPTION_BUNDLE)

        if (bundle != null) {
            val transitionName = bundle.getString(PRODUCT_DESCRIPTION_TRANSITION_NAME)

            if (transitionName != null) {
                window.sharedElementEnterTransition =
                    TransitionInflater.from(this)
                        .inflateTransition(R.transition.shared_element_transition_image)

                ViewCompat.setTransitionName(pdpParentCarouselImage, transitionName)
            }
        }
    }
}