package SandwichPackage;

public class Cheese extends Ingredient{

    private Cheese(double weight) {
        super("Cheese", weight);
    }

    public static Cheese create(double weight) {
        if (!Ingredient.isValidWeight("Cheese", weight)) {
            return null;
        }
        return new Cheese(weight);
    }
    @Override
    public double calculateCalories() {
        return 2.0 * getWeight() * 1.2;
    }
}
