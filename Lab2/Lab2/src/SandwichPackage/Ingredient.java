package SandwichPackage;

public class Ingredient {

    private String typeName;
    private double weight;

    protected Ingredient(String typeName, double weight) {
        this.typeName = typeName;
        this.weight = weight;
    }

    protected static boolean isValidWeight(String typeName, double weight) {
        if (weight<1||weight>50) {
            System.out.println(typeName+" weight should be in the range [1..50].");
            return false;
        }
        return true;
    }

    public String getTypeName() {
        return typeName;
    }
    public double getWeight() {
        return weight;
    }
    public double calculateCalories() {
        return 0.0;
    }
    @Override
    public String toString() {
        return typeName + " (" + weight + "g)";
    }
}
