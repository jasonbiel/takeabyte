package co.za.takeabyte.gradalot2020.repository.impl;

import java.util.ArrayList;
import java.util.List;

import co.za.takeabyte.gradalot2020.promotions.uimodel.UIModelPromotionItem;
import co.za.takeabyte.gradalot2020.repository.IRepositoryPromotions;

public class RepositoryPromotions implements IRepositoryPromotions {

    @Override
    public List<UIModelPromotionItem> getPromotions() {
        return generateDummyData();
    }

    private List<UIModelPromotionItem> generateDummyData() {
        ArrayList<UIModelPromotionItem> models = new ArrayList<>();

        UIModelPromotionItem model1 = new UIModelPromotionItem();
        model1.setPrice(8.999);
        model1.setTitle("GoldAir - 40cm Oscillating Fan - Black");
        models.add(model1);

        UIModelPromotionItem model2 = new UIModelPromotionItem();
        model2.setPrice(8.999);
        model2.setTitle("GoldAir - 40cm Oscillating Fan - Black");
        models.add(model2);

        UIModelPromotionItem model3 = new UIModelPromotionItem();
        model3.setPrice(8.999);
        model3.setTitle("GoldAir - 40cm Oscillating Fan - Black");
        models.add(model3);

        UIModelPromotionItem model4 = new UIModelPromotionItem();
        model4.setPrice(8.999);
        model4.setTitle("GoldAir - 40cm Oscillating Fan - Black");
        models.add(model4);

        UIModelPromotionItem model5 = new UIModelPromotionItem();
        model5.setPrice(8.999);
        model5.setTitle("GoldAir - 40cm Oscillating Fan - Black");
        models.add(model5);

        UIModelPromotionItem model6 = new UIModelPromotionItem();
        model6.setPrice(8.999);
        model6.setTitle("GoldAir - 40cm Oscillating Fan - Black");
        models.add(model6);

        UIModelPromotionItem model7 = new UIModelPromotionItem();
        model7.setPrice(8.999);
        model7.setTitle("GoldAir - 40cm Oscillating Fan - Black");
        models.add(model7);

        UIModelPromotionItem model8 = new UIModelPromotionItem();
        model8.setPrice(8.999);
        model8.setTitle("GoldAir - 40cm Oscillating Fan - Black");
        models.add(model8);

        return models;
    }
}
