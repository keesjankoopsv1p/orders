package nl.hu.bep3.kees.orders.core.application.services;

import nl.hu.bep3.kees.orders.core.domain.exception.MealIngredientsOutOfStock;
import nl.hu.bep3.kees.orders.core.ports.storage.StockRepository;
import nl.hu.bep3.kees.orders.infrastructure.driven.storage.result.IngredientResult;

import java.util.Hashtable;
import java.util.List;

public class IngredientService {
    private final StockRepository ingredientGateway;


    public IngredientService(StockRepository ingredientGateway) {
        this.ingredientGateway = ingredientGateway;
    }

    public void Validate(Hashtable<String, Integer> orderedMeals) {
        for (String mealId: orderedMeals.keySet()) {
            List<IngredientResult> ingredientResultList = ingredientGateway.getIngredientsQuantityByMeal(mealId);
            for (IngredientResult ingredient: ingredientResultList ) {
                if (ingredient.quantity < orderedMeals.get(mealId)) {
                    throw new MealIngredientsOutOfStock("Meal ingredients with id:" + mealId + "out of stock");
                }
            }
        }
    }
}
