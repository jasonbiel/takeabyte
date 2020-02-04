package co.za.takeabyte.gradalot2020.promotions.itemdecoration

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import co.za.takeabyte.gradalot2020.R

// TODO: Margin on promotion items seems incorrect

class ItemDecorationPromotion(context: Context) : RecyclerView.ItemDecoration() {

    private val marginBig = context.resources.getDimensionPixelSize(R.dimen.margin_large)

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
    }
}