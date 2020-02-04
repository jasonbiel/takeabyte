package co.za.takeabyte.gradalot2020;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

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
        Toast.makeText(this, model.getTitle(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPromotionsAllDealsSelected() {
        Toast.makeText(this, "All deals selected", Toast.LENGTH_SHORT).show();
    }

    private void addAndRenderPromotionsCarousel() {
        if(homeRoot != null) {
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
