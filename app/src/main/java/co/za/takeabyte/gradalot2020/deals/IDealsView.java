package co.za.takeabyte.gradalot2020.deals;

import java.util.List;

import co.za.takeabyte.gradalot2020.promotions.uimodel.UIModelPromotionItem;

public interface IDealsView {

    void configureDealsContainer();

    void renderContentItems(List<UIModelPromotionItem> items);

}
