package SandwichPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sandwich {
    private  String name;
    private Bread bread;
    private List<Ingredient> ingredients;

    private Sandwich(String name, Bread bread) {
        this.name = name;
        this.bread = bread;
        this.ingredients = new ArrayList<>();
    }

    public static  Sandwich create(String name, Bread bread) {
        if (name == null || name.trim().isEmpty() || name.trim().length() > 15) {
            System.out.println("Sandwich name should be between 1 and 15 symbols.");
            return null;
        }
        if (bread == null) {
            return  null;
        }
        return new Sandwich(name.trim(), bread);
    }

    public boolean addIngredient(Ingredient ingredient) {
        if (ingredient == null) {
            return false;
        }
        if (ingredients.size() >= 10) {
            System.out.println("The number of ingredients should be in the range [0..10].");
            return false;
        }
        ingredients.add(ingredient);
        return true;
    }
    public double calculateTotalCalories() {
        double totalCalories = bread.calculateCalories();
        for (Ingredient ingredient : ingredients) {
            totalCalories += ingredient.calculateCalories();
        }
        return totalCalories;
    }
    public List<Ingredient> getIngredients() {
        return Collections.unmodifiableList(ingredients);
    }
    @Override
    public String toString() {
        String result = "Sandwich name: " + name + System.lineSeparator();
        result += "Bread: " + bread.toString() + System.lineSeparator();
        result += "Ingredients:" + System.lineSeparator();

        if (ingredients.isEmpty()) {
            result += "- no ingredients" + System.lineSeparator();
        } else  {
            for (Ingredient ingredient : ingredients) {
                result += "- " + ingredient.toString() + System.lineSeparator();
            }
        }
        result += String.format("Calories: %.2f", calculateTotalCalories()) +  System.lineSeparator();
        return result;
    }
}
