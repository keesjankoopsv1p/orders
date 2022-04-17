package nl.hu.bep3.kees.orders.core.ports.storage;

import nl.hu.bep3.kees.orders.infrastructure.driven.storage.result.IngredientResult;

import java.util.List;

public interface StockRepository {
    List<IngredientResult> getIngredientsQuantityByMeal(String id);
}
