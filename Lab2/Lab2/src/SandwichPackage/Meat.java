package SandwichPackage;

public class Meat extends Ingredient {

    private Meat(double weight) {
        super("Meat", weight);
    }
    public static Meat create(double weight) {
        if (!Ingredient.isValidWeight("Meat", weight)) {
            return null;
        }
        return new Meat(weight);
    }

    @Override
    public double calculateCalories() {
        return 2.0 * getWeight() * 1.3;
    }
}
