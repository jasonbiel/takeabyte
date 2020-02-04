package co.za.takeabyte.gradalot2020.productdescription.viewmodel

import android.content.Context
import android.os.Bundle
import androidx.annotation.DrawableRes
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import co.za.takeabyte.gradalot2020.productdescription.IProductDescriptionView
import co.za.takeabyte.gradalot2020.productdescription.ProductDescriptionActivity

class ViewModelProductDescription : ViewModel(), LifecycleObserver {

    private var context: Context? = null

    private var title: String = String()

    @DrawableRes
    private var imageUrl: Int = -1

    fun setContext(context: Context) {
        this.context = context
    }

    fun setDataBundle(data: Bundle?) {
        title = data?.getString(ProductDescriptionActivity.PRODUCT_DESCRIPTION_TITLE) ?: ""
        imageUrl = data?.getInt(ProductDescriptionActivity.PRODUCT_DESCRIPTION_IMAGE) ?: -1
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        renderUI()
    }

    private fun renderUI() {
        val context = context
        if (context is IProductDescriptionView) {
            if (imageUrl == -1) {
//                render placeholder
            } else {
                context.renderImage(imageUrl)
            }

            context.renderTitle(title)
        }
    }

}