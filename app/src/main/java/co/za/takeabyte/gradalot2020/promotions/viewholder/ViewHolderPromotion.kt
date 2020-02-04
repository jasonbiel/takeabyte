package co.za.takeabyte.gradalot2020.promotions.viewholder

import android.view.View
import android.widget.ImageView
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import co.za.takeabyte.gradalot2020.R
import co.za.takeabyte.gradalot2020.promotions.uimodel.UIModelPromotionItem
import kotlinx.android.synthetic.main.promotions_item_layout.view.*

// TODO: Promotion Item price is not displaying.

class ViewHolderPromotion(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindView(
        model: UIModelPromotionItem,
        onItemSelectedListener: (ImageView, UIModelPromotionItem) -> Unit
    ) {

        ViewCompat.setTransitionName(
            itemView.promotionsItemImage,
            itemView.context.resources.getString(R.string.transition_name_image).replace(
                "%s",
                "$adapterPosition"
            )
        )

        itemView.promotionsItemImage.setImageResource(model.imageRes)
        itemView.promotionsItemTitle.text = model.title
        itemView.promotionsItemRootView.setOnClickListener {
            onItemSelectedListener.invoke(itemView.promotionsItemImage, model)
        }
    }
}