package co.za.takeabyte.gradalot2020.promotions.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import co.za.takeabyte.gradalot2020.promotions.uimodel.UIModelPromotionItem
import kotlinx.android.synthetic.main.promotions_item_layout.view.*

class ViewHolderPromotion(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindView(model: UIModelPromotionItem, onItemSelectedListener: (UIModelPromotionItem) -> Unit) {
        itemView.promotionsItemImage.setImageResource(model.imageRes)
        itemView.promotionsItemTitle.text = model.title
        itemView.promotionsItemPrice.text = model.getDisplayPrice()
        itemView.promotionsItemRootView.setOnClickListener {
            onItemSelectedListener.invoke(model)
        }
    }
}