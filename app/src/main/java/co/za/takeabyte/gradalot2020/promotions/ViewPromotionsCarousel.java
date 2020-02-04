package co.za.takeabyte.gradalot2020.promotions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.button.MaterialButton;

import java.util.List;

import co.za.takeabyte.gradalot2020.R;
import co.za.takeabyte.gradalot2020.promotions.adapter.AdapterPromotions;
import co.za.takeabyte.gradalot2020.promotions.itemdecoration.ItemDecorationPromotion;
import co.za.takeabyte.gradalot2020.promotions.listener.OnPromotionsListener;
import co.za.takeabyte.gradalot2020.promotions.uimodel.UIModelPromotionItem;
import co.za.takeabyte.gradalot2020.promotions.viewmodel.ViewModelPromotions;

// TODO: Promotion Title is not being displayed?

public class ViewPromotionsCarousel {
    private View rootView;

    private TextView promotionsTitle;
    private MaterialButton promotionsAllDeals;
    private RecyclerView promotionsRecyclerView;
    private ShimmerFrameLayout promotionsShimmer;

    private OnPromotionsListener onPromotionsListener;

    public ViewPromotionsCarousel(
            @NonNull ViewGroup parentViewGroup,
            @NonNull ViewModelPromotions viewModel,
            @NonNull OnPromotionsListener listener
    ) {
        rootView = LayoutInflater.from(parentViewGroup.getContext())
                .inflate(R.layout.promotions_layout, parentViewGroup, false);

        if (rootView != null) {
            promotionsTitle = rootView.findViewById(R.id.promotionsTitle);
            promotionsAllDeals = rootView.findViewById(R.id.promotionsAllDeals);
            promotionsRecyclerView = rootView.findViewById(R.id.promotionsRecyclerView);
            promotionsShimmer = rootView.findViewById(R.id.promotionsShimmer);
        }

        onPromotionsListener = listener;

        initViewPromotionsCarousel(viewModel);
    }

    public View getRootView() {
        return rootView;
    }

    private void initViewPromotionsCarousel(@NonNull ViewModelPromotions viewModel) {
        final Context context = getContext();
        if (context != null) {
            initPromotionsContainer(context);
            initPromotionsTitle();

            observeViewModel(context, viewModel);
            getPromotions(viewModel);
        }
    }

    private void initPromotionsContainer(@NonNull Context context) {
        if (promotionsRecyclerView != null &&
                onPromotionsListener != null) {
            final AdapterPromotions adapter = new AdapterPromotions(onPromotionsListener);
            promotionsRecyclerView.setAdapter(adapter);

            final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            promotionsRecyclerView.setLayoutManager(layoutManager);

            final RecyclerView.ItemDecoration itemDecoration = new ItemDecorationPromotion(context);
            promotionsRecyclerView.addItemDecoration(itemDecoration);

            final SnapHelper snapHelper = new LinearSnapHelper();
            snapHelper.attachToRecyclerView(promotionsRecyclerView);
        }
    }

    private void initPromotionsTitle() {
        if (promotionsAllDeals != null) {
            promotionsAllDeals.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onPromotionsListener != null) {
                        onPromotionsListener.onPromotionsAllDealsSelected();
                    }
                }
            });
        }
    }

    private void observeViewModel(
            @NonNull Context context,
            @NonNull ViewModelPromotions viewModel
    ) {
        final LifecycleOwner lifecycleOwner = getLifecycleOwner(context);
        if (lifecycleOwner != null &&
                viewModel.getPromotions() != null) {

            viewModel.getPromotions().observe(lifecycleOwner, promotionsObserver);
        }
    }

    private void getPromotions(@NonNull ViewModelPromotions viewModel) {
        if (promotionsShimmer != null) {
            promotionsShimmer.setVisibility(View.VISIBLE);
            promotionsShimmer.startShimmer();
            viewModel.fetchPromotions();
        }
    }

    private Observer<List<UIModelPromotionItem>> promotionsObserver =
            new Observer<List<UIModelPromotionItem>>() {
                @Override
                public void onChanged(List<UIModelPromotionItem> uiModelPromotionItems) {
                    if (rootView != null &&
                            promotionsShimmer != null &&
                            promotionsAllDeals != null &&
                            promotionsTitle != null &&
                            promotionsRecyclerView != null) {

                        promotionsShimmer.stopShimmer();
                        promotionsShimmer.setVisibility(View.GONE);

                        promotionsAllDeals.setVisibility(View.VISIBLE);

                        if (promotionsRecyclerView.getAdapter() != null &&
                                promotionsRecyclerView.getAdapter() instanceof AdapterPromotions) {

                            final AdapterPromotions adapter =
                                    (AdapterPromotions) promotionsRecyclerView.getAdapter();

                            adapter.setDataSet(uiModelPromotionItems);
                        }
                        promotionsRecyclerView.setVisibility(View.VISIBLE);
                    }
                }
            };

    private LifecycleOwner getLifecycleOwner(Context context) {
        if (context instanceof LifecycleOwner) {
            return (LifecycleOwner) context;
        }

        return null;
    }

    private Context getContext() {
        if (rootView != null &&
                rootView.getContext() != null) {
            return rootView.getContext();
        }

        return null;
    }
}
