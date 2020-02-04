package co.za.takeabyte.gradalot2020.promotions.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import co.za.takeabyte.gradalot2020.R;
import co.za.takeabyte.gradalot2020.promotions.uimodel.UIModelPromotionItem;

public class ViewHolderPromotion extends RecyclerView.ViewHolder {

    private ViewGroup promotionsItemRoot;
    private ImageView promotionsItemImage;
    private TextView promotionsItemTitle;
    private TextView promotionsItemPrice;

    public ViewHolderPromotion(@NonNull View itemView) {
        super(itemView);
        promotionsItemImage = itemView.findViewById(R.id.promotionsItemImage);
        promotionsItemTitle = itemView.findViewById(R.id.promotionsItemTitle);
        promotionsItemPrice = itemView.findViewById(R.id.promotionsItemPrice);
        promotionsItemRoot = itemView.findViewById(R.id.promotionsItemRootView);
    }

    public void bindView(@NonNull UIModelPromotionItem model) {
        if (promotionsItemImage != null &&
                promotionsItemPrice != null &&
                promotionsItemTitle != null) {

            ViewCompat.setTransitionName(promotionsItemImage, itemView.getContext().getResources().getString(R.string.transition_name_image).replace("%s", "" + getAdapterPosition()));

            promotionsItemImage.setImageResource(model.getImageRes());
            promotionsItemTitle.setText(model.getTitle());
            promotionsItemPrice.setText(model.getDisplayPrice());
        }
    }

    public void setOnClickListener(View.OnClickListener listener) {
        if (promotionsItemRoot != null) {
            promotionsItemRoot.setOnClickListener(listener);
        }
    }
}
