package co.za.takeabyte.gradalot2020.promotions.uimodel;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

import co.za.takeabyte.gradalot2020.R;

public class UIModelPromotionItem {
    private @DrawableRes int imageRes = R.drawable.product_image;
    private double price = Double.MIN_VALUE;

    private String title = "";

    public void setImageRes(@DrawableRes int imageRes) {
        this.imageRes = imageRes;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getDisplayPrice() {
        return Double.toString(price);
    }
}
