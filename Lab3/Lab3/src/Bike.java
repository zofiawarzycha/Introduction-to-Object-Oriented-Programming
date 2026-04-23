public class Bike extends Vehicle{

    public boolean hasBasket;

    public Bike(String brand, String model, double MaxSpeed, boolean hasBasket) {
        super(brand, model, MaxSpeed);
        this.hasBasket = hasBasket;
    }
    public boolean getHasBasket() {
        return hasBasket;
    }
    @Override
    public void showInfo() {
        System.out.println("Bike: " + getBrand() + ", model: " + getModel() + ", max speed: " + getMaxSpeed() + " km/h, has basket: " + getHasBasket());
    }
    public void ecoFriendly() {
        System.out.println(getBrand() + ", model: " + getModel() + " is eco friendly.");
    }
}
