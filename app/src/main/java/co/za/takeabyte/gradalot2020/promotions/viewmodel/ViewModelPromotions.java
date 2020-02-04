package co.za.takeabyte.gradalot2020.promotions.viewmodel;

import android.os.CountDownTimer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import co.za.takeabyte.gradalot2020.promotions.uimodel.UIModelPromotionItem;
import co.za.takeabyte.gradalot2020.repository.IRepositoryPromotions;
import co.za.takeabyte.gradalot2020.repository.impl.RepositoryPromotions;

public class ViewModelPromotions extends ViewModel {

    private IRepositoryPromotions repository = new RepositoryPromotions();
    private MutableLiveData<List<UIModelPromotionItem>> promotions = new MutableLiveData<>();

    public LiveData<List<UIModelPromotionItem>> getPromotions() {
        return promotions;
    }

    public void fetchPromotions() {
        new CountDownTimer(5000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                promotions.postValue(repository.getPromotions());
            }
        }.start();
    }
}
