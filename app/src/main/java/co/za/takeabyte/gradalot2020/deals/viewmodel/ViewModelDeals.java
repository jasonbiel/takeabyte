package co.za.takeabyte.gradalot2020.deals.viewmodel;

import android.content.Context;
import android.os.CountDownTimer;

import androidx.lifecycle.ViewModel;

import java.util.List;

import co.za.takeabyte.gradalot2020.deals.IDealsView;
import co.za.takeabyte.gradalot2020.promotions.uimodel.UIModelPromotionItem;
import co.za.takeabyte.gradalot2020.repository.IRepositoryPromotions;
import co.za.takeabyte.gradalot2020.repository.impl.RepositoryPromotions;

public class ViewModelDeals extends ViewModel {

    private IRepositoryPromotions repository = new RepositoryPromotions();

    private Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public void getPromotions() {
        CountDownTimer countDownTimer = new CountDownTimer(2000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                renderUI(repository.getPromotions());
            }
        };
        countDownTimer.start();
    }

    private void renderUI(List<UIModelPromotionItem> items) {
        if (context instanceof IDealsView) {
            IDealsView dealsView = (IDealsView) context;

            dealsView.configureDealsContainer();
            dealsView.renderContentItems(items);
        }
    }

}
