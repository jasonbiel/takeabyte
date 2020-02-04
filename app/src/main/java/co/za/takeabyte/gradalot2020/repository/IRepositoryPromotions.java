package co.za.takeabyte.gradalot2020.repository;

import java.util.List;

import co.za.takeabyte.gradalot2020.promotions.uimodel.UIModelPromotionItem;

public interface IRepositoryPromotions {
    List<UIModelPromotionItem> getPromotions();
}
