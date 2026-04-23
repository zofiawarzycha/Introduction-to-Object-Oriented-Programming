package SandwichPackage;

import java.util.Locale;

public class Bread {

    private String type;
    private String preparation;
    private double weight;

    private Bread(String type, String preparation, double weight) {
        this.type = type;
        this.preparation = preparation;
        this.weight = weight;
    }
    public static Bread create(String type, String preparation, double weight) {
        if (type == null || (!type.equalsIgnoreCase("white") &&  !type.equalsIgnoreCase("wholegrain"))) {
            System.out.println("Invalid type of bread.");
            return null;
        }
        if (preparation == null || (!preparation.equalsIgnoreCase("toasted") && !preparation.equalsIgnoreCase("fresh"))) {
            System.out.println("Invalid bread preparation.");
            return null;
        }
        if (weight < 1 || weight > 200) {
            System.out.println("Bread weight should be in the range [1..200].");
            return null;
        }
        return new Bread(type.toLowerCase(), preparation.toLowerCase(), weight);
    }

    public double calculateCalories() {
        double typeModifier;
        if (type.equals("white")) {
            typeModifier = 1.4;
        } else {
            typeModifier = 1.0;
        }
        double prepModifier;
        if (preparation.equals("toasted")) {
            prepModifier = 1.1;
        } else {
            prepModifier = 1.0;
        }
        return (2.0 * weight) *  typeModifier * prepModifier;
    }
    public String getType() {
        return type;
    }
    public String getPreparation() {
        return preparation;
    }
    public double getWeight() {
        return weight;
    }
    @Override
    public String toString() {
        return preparation + " " + type + " bread (" + weight + " g)";
    }
}
