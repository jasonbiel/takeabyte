package co.za.takeabyte.gradalot2020.deals

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import co.za.takeabyte.gradalot2020.R
import co.za.takeabyte.gradalot2020.deals.adapter.AdapterDeals
import co.za.takeabyte.gradalot2020.deals.viewmodel.ViewModelDeals
import co.za.takeabyte.gradalot2020.promotions.uimodel.UIModelPromotionItem
import kotlinx.android.synthetic.main.deals_layout.*

class DealsActivity : AppCompatActivity(), IDealsView {

    private var viewModelDeals: ViewModelDeals? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.deals_layout)

        viewModelDeals = ViewModelProvider(this)[ViewModelDeals::class.java]

        viewModelDeals?.setContext(this)
        viewModelDeals?.getPromotions()
    }

    override fun configureDealsContainer() {
        dealsContentContainer.layoutManager = GridLayoutManager(
            this, 2, GridLayoutManager.VERTICAL, false
        )

        dealsContentContainer.adapter = AdapterDeals(onPromotionItemSelected)
    }

    private val onPromotionItemSelected: (UIModelPromotionItem) -> Unit = { model ->
        Toast.makeText(this, "Selected - ${model.title}", Toast.LENGTH_SHORT).show()
    }

    override fun renderContentItems(items: List<UIModelPromotionItem>) {
        val adapter = dealsContentContainer.adapter
        if (adapter is AdapterDeals) {
            adapter.dataSet = items
        }
    }
}