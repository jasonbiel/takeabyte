package co.za.takeabyte.gradalot2020.productdescription.viewmodel;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import co.za.takeabyte.gradalot2020.productdescription.IProductDescriptionView;
import co.za.takeabyte.gradalot2020.productdescription.ProductDescriptionActivity;

public class ViewModelProductDescription extends ViewModel implements LifecycleObserver {

    private Context context;

    private String title;

    @DrawableRes
    private int imageRes = -1;

    public void setContext(Context context) {
        this.context = context;
    }

    public void setDataBundle(@Nullable Bundle dataBundle) {
        if (dataBundle != null) {
            title = dataBundle.getString(ProductDescriptionActivity.PRODUCT_DESCRIPTION_TITLE);
            imageRes = dataBundle.getInt(ProductDescriptionActivity.PRODUCT_DESCRIPTION_IMAGE);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        renderUI();
    }

    private void renderUI() {
        if (context instanceof IProductDescriptionView) {
            IProductDescriptionView productDescriptionView = (IProductDescriptionView) context;

            if (imageRes == -1) {
                //render placeholder
            } else {
                productDescriptionView.renderImage(imageRes);
            }

            productDescriptionView.renderTitle(title);
        }
    }

}
