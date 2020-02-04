package co.za.takeabyte.gradalot2020.promotions.listener;

import android.widget.ImageView;

import androidx.annotation.NonNull;

import co.za.takeabyte.gradalot2020.promotions.uimodel.UIModelPromotionItem;

public interface OnPromotionsListener {
    void onPromotionsItemSelected(@NonNull ImageView imageView, @NonNull UIModelPromotionItem model);

    void onPromotionsAllDealsSelected();
}
