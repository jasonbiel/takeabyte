package co.za.takeabyte.gradalot2020.promotions.listener;

import androidx.annotation.NonNull;

import co.za.takeabyte.gradalot2020.promotions.uimodel.UIModelPromotionItem;

public interface OnPromotionsListener {
    void onPromotionsItemSelected(@NonNull UIModelPromotionItem model);

    void onPromotionsAllDealsSelected();
}
