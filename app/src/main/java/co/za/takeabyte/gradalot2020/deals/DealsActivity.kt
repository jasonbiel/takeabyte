package co.za.takeabyte.gradalot2020.deals

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import co.za.takeabyte.gradalot2020.deals.viewmodel.ViewModelDeals

class DealsActivity : AppCompatActivity() {

    private var viewModelDeals: ViewModelDeals? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModelDeals = ViewModelProvider(this)[ViewModelDeals::class.java]

        lifecycle.addObserver(viewModelDeals!!)
    }
}