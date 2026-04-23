package SandwichPackage;

public class SandwichTester {
    public static void main(String[] args) {

        System.out.println("=== Creating a valid sandwich ===");

        Bread validBread = Bread.create("wholegrain", "toasted", 100);
        Sandwich healthySub = Sandwich.create("Healthy Sub", validBread);

        if (healthySub != null) {
            healthySub.addIngredient(Meat.create(30));
            healthySub.addIngredient(Cheese.create(20));
            healthySub.addIngredient(Veggies.create(15));
            healthySub.addIngredient(Sauce.create(10));
        }
        System.out.println(healthySub);
        System.out.println();


        System.out.println("=== Invalid examples ===");
        Bread badType = Bread.create("rye", "fresh", 100);

        Bread badPrep = Bread.create("white", "burnt", 100);

        Bread badWeight = Bread.create("white", "fresh", 300);

        Ingredient badMeat = Meat.create(100);

        Sandwich badName = Sandwich.create("ThisNameIsWayTooLongForThatProgram", validBread);
        System.out.println();


        System.out.println("=== Limit of ingredients test ===");
        Sandwich loadedSub = Sandwich.create("Loaded Sub", Bread.create("white", "fresh", 150));
        if (loadedSub != null) {
            for (int i = 1; i <= 11; i++) {
                boolean added = loadedSub.addIngredient(Cheese.create(5));
                System.out.println("Adding ingredient " + i + ": " + added);
            }
        }
        System.out.println();
        System.out.println(loadedSub);
    }
}