package nl.hu.bep3.kees.orders.core.domain.exception;

public class MealIngredientsOutOfStock extends RuntimeException{
    public MealIngredientsOutOfStock(String message) { super(message); }
}
