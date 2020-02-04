package co.za.takeabyte.gradalot2020.promotions.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import co.za.takeabyte.gradalot2020.R
import co.za.takeabyte.gradalot2020.promotions.uimodel.UIModelPromotionItem
import co.za.takeabyte.gradalot2020.promotions.viewholder.ViewHolderPromotion

class AdapterPromotions(
    private val onPromotionItemSelected: (ImageView, UIModelPromotionItem) -> Unit
) : RecyclerView.Adapter<ViewHolderPromotion>() {
    private var dataSet: List<UIModelPromotionItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPromotion {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.promotions_item_layout,
            parent,
            false)

        return ViewHolderPromotion(itemView)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: ViewHolderPromotion, position: Int) {
        val model = dataSet[position]
        holder.bindView(model, onPromotionItemSelected)
    }

    fun setDataSet(models: List<UIModelPromotionItem>) {
        dataSet = models
        notifyDataSetChanged()
    }
}