package co.za.takeabyte.gradalot2020.promotions

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import co.za.takeabyte.gradalot2020.R
import co.za.takeabyte.gradalot2020.promotions.adapter.AdapterPromotions
import co.za.takeabyte.gradalot2020.promotions.itemdecoration.ItemDecorationPromotion
import co.za.takeabyte.gradalot2020.promotions.uimodel.UIModelPromotionItem
import co.za.takeabyte.gradalot2020.promotions.viewmodel.ViewModelPromotions
import kotlinx.android.synthetic.main.promotions_layout.view.*

// TODO: Promotions Title is not displaying

class ViewPromotionsCarousel(
    parentViewGroup: ViewGroup,
    viewModel: ViewModelPromotions,
    private val onAllDealsSelected: () -> Unit,
    private val onPromotionItemSelected: (ImageView, UIModelPromotionItem) -> Unit
) {
    val rootView: View = LayoutInflater.from(parentViewGroup.context).inflate(
        R.layout.promotions_layout,
        parentViewGroup,
        false
    )

    init {

        initPromotionsContainer()
        initPromotionsTitle()

        observeViewModel(
            parentViewGroup.context,
            viewModel
        )

        getPromotions(viewModel)
    }

    private fun initPromotionsContainer() {
        rootView.promotionsRecyclerView.adapter =
            AdapterPromotions(
                onPromotionItemSelected = onPromotionItemSelected
            )

        rootView.promotionsRecyclerView.layoutManager = LinearLayoutManager(rootView.context).apply {
            orientation = LinearLayoutManager.HORIZONTAL
        }

        rootView.promotionsRecyclerView.addItemDecoration(ItemDecorationPromotion(rootView.context))

        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(rootView.promotionsRecyclerView)
    }

    private fun initPromotionsTitle() {
        rootView.promotionsAllDeals.setOnClickListener { view ->
            onAllDealsSelected.invoke()
        }
    }

    private fun observeViewModel(context: Context, viewModel: ViewModelPromotions) {
        getLifecycleOwner(context)?.let { lifecycleOwner ->
            viewModel.promotions.observe(lifecycleOwner, Observer {  models ->
                rootView.promotionsShimmer.stopShimmer()
                rootView.promotionsShimmer.visibility = View.GONE

                rootView.promotionsAllDeals.visibility = View.VISIBLE

                (rootView.promotionsRecyclerView.adapter as? AdapterPromotions)?.setDataSet(models)
                rootView.promotionsRecyclerView.visibility = View.VISIBLE
            })
        }
    }

    private fun getPromotions(viewModel: ViewModelPromotions) {
        rootView.promotionsShimmer.visibility = View.VISIBLE
        rootView.promotionsShimmer.startShimmer()
        viewModel.getPromotions()
    }

    private fun getLifecycleOwner(context: Context): LifecycleOwner? {
        return context as? LifecycleOwner
    }
}