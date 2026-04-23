public class Car extends Vehicle {

    private int numberOfDoors;

    public Car(String brand, String model, double MaxSpeed, int numberOfDoors) {
        super(brand, model, MaxSpeed);
        this.numberOfDoors = numberOfDoors;
    }
    public int getNumberOfDoors() {
        return numberOfDoors;
    }
    @Override
    public void showInfo() {
        System.out.println("Car: " + getBrand() + ", model: " + getModel() + ", max speed: "
                + getMaxSpeed() + " km/h, with " + getNumberOfDoors() + " doors.");
    }
    public void cityDriving() {
        System.out.println(getBrand() + ", model: " + getModel() + " is driving in the city.");
    }

}
