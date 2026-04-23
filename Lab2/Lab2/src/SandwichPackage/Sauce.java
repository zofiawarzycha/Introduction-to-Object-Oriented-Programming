package SandwichPackage;

public class Sauce extends Ingredient{

    private Sauce(double weight) {
        super("Sauce", weight);
    }
    public static Sauce create(double weight) {
        if (!Ingredient.isValidWeight("Sauce", weight)) {
            return null;
        }
        return new Sauce(weight);
    }
    @Override
    public double calculateCalories() {
        return 2.0 * getWeight() * 0.8;
    }
}
