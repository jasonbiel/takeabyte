package co.za.takeabyte.gradalot2020;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import co.za.takeabyte.gradalot2020.deals.DealsActivity;
import co.za.takeabyte.gradalot2020.productdescription.ProductDescriptionActivity;
import co.za.takeabyte.gradalot2020.promotions.ViewPromotionsCarousel;
import co.za.takeabyte.gradalot2020.promotions.listener.OnPromotionsListener;
import co.za.takeabyte.gradalot2020.promotions.uimodel.UIModelPromotionItem;
import co.za.takeabyte.gradalot2020.promotions.viewmodel.ViewModelPromotions;

public class HomeActivity extends AppCompatActivity implements OnPromotionsListener {
    private ViewGroup homeRoot;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);

        homeRoot = findViewById(R.id.homeRootView);

        addAndRenderPromotionsCarousel();
    }

    @Override
    public void onPromotionsItemSelected(@NonNull UIModelPromotionItem model) {
        Intent intent = new Intent(this, ProductDescriptionActivity.class);

        Bundle pdpBundle = new Bundle();
        pdpBundle.putString(ProductDescriptionActivity.PRODUCT_DESCRIPTION_TITLE, model.getTitle());
        pdpBundle.putInt(ProductDescriptionActivity.PRODUCT_DESCRIPTION_IMAGE, model.getImageRes());

        intent.putExtra(ProductDescriptionActivity.PRODUCT_DESCRIPTION_BUNDLE, pdpBundle);

        startActivity(intent);
    }

    @Override
    public void onPromotionsAllDealsSelected() {
        Intent intent = new Intent(this, DealsActivity.class);
        startActivity(intent);
    }

    private void addAndRenderPromotionsCarousel() {
        if (homeRoot != null) {
            ViewModelPromotions viewModelPromotions = new ViewModelProvider(this)
                    .get(ViewModelPromotions.class);

            final ViewPromotionsCarousel viewPromotionsCarousel = new ViewPromotionsCarousel(
                    homeRoot,
                    viewModelPromotions,
                    this
            );

            final View rootView = viewPromotionsCarousel.getRootView();
            if (rootView != null) {
                homeRoot.addView(rootView);
            }
        }

    }
}
