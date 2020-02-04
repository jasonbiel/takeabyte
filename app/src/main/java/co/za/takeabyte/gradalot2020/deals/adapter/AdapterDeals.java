package co.za.takeabyte.gradalot2020.deals.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import co.za.takeabyte.gradalot2020.R;
import co.za.takeabyte.gradalot2020.promotions.listener.OnPromotionsListener;
import co.za.takeabyte.gradalot2020.promotions.uimodel.UIModelPromotionItem;
import co.za.takeabyte.gradalot2020.promotions.viewholder.ViewHolderPromotion;

public class AdapterDeals extends RecyclerView.Adapter<ViewHolderPromotion> {

    private List<UIModelPromotionItem> dataSet = new ArrayList<>();
    private OnPromotionsListener onPromotionsListener;

    public AdapterDeals(@NonNull OnPromotionsListener onPromotionsListener) {
        this.onPromotionsListener = onPromotionsListener;
    }

    @NonNull
    @Override
    public ViewHolderPromotion onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.deals_item_layout, parent, false);

        return new ViewHolderPromotion(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPromotion holder, int position) {
        final UIModelPromotionItem model = dataSet.get(position);
        if (model != null) {
            holder.bindView(model);
            holder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onPromotionsListener != null) {
                        onPromotionsListener.onPromotionsItemSelected(model);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public void setDataSet(@NonNull List<UIModelPromotionItem> models) {
        dataSet = models;
        notifyDataSetChanged();
    }
}
