package SandwichPackage;

public class Veggies extends Ingredient{

    private Veggies(double weight) {
        super("Veggies", weight);
    }

    public static Veggies create(double weight) {
        if (!Ingredient.isValidWeight("Veggies", weight)) {
            return null;
        }
        return new Veggies(weight);
    }
    @Override
    public double calculateCalories() {
        return 2.0 * getWeight() * 0.7;
    }
}
