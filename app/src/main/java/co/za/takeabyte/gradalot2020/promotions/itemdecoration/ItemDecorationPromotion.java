package co.za.takeabyte.gradalot2020.promotions.itemdecoration;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import co.za.takeabyte.gradalot2020.R;

// TODO: Margin on promotion items seems incorrect.

public class ItemDecorationPromotion extends RecyclerView.ItemDecoration {

    private int marginLarge;

    public ItemDecorationPromotion(@NonNull final Context context) {
        if (context.getResources() != null) {
            marginLarge = context.getResources().getDimensionPixelSize(R.dimen.margin_large);
        }
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
    }
}
