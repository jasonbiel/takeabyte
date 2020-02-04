package co.za.takeabyte.gradalot2020.deals;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import co.za.takeabyte.gradalot2020.R;
import co.za.takeabyte.gradalot2020.deals.adapter.AdapterDeals;
import co.za.takeabyte.gradalot2020.deals.viewmodel.ViewModelDeals;
import co.za.takeabyte.gradalot2020.promotions.listener.OnPromotionsListener;
import co.za.takeabyte.gradalot2020.promotions.uimodel.UIModelPromotionItem;

//TODO: Selecting a Product should show ProductDescription Activity.
//TODO: Product item selection requires ripple effect.

//TODO: Bonus, add Activity shared element transition.

public class DealsActivity extends AppCompatActivity implements IDealsView, OnPromotionsListener {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deals_layout);

        recyclerView = findViewById(R.id.dealsContentContainer);

        ViewModelDeals viewModelDeals = new ViewModelProvider(this).get(ViewModelDeals.class);

        viewModelDeals.setContext(this);
        viewModelDeals.getPromotions();
    }

    @Override
    public void configureDealsContainer() {
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new GridLayoutManager(
                    this, 2, GridLayoutManager.VERTICAL, false
            ));

            recyclerView.setAdapter(new AdapterDeals(this));
        }
    }

    @Override
    public void onPromotionsItemSelected(@NonNull ImageView imageView, @NonNull UIModelPromotionItem model) {
        Toast.makeText(this, "Selected - " + model.getTitle(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPromotionsAllDealsSelected() {
    }

    @Override
    public void renderContentItems(List<UIModelPromotionItem> items) {
        if (recyclerView != null &&
                recyclerView.getAdapter() instanceof AdapterDeals) {

            AdapterDeals adapterDeals = (AdapterDeals) recyclerView.getAdapter();

            adapterDeals.setDataSet(items);
        }
    }
}
