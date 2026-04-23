public abstract class Vehicle {

    private String brand;
    private String model;
    private double MaxSpeed;

    public Vehicle(String brand, String model, double MaxSpeed) {
        this.brand = brand;
        this.model = model;
        this.MaxSpeed = MaxSpeed;
    }
    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public double getMaxSpeed() {
        return MaxSpeed;
    }
    public void showInfo() {
        System.out.println("Brand: " + getBrand() + ", model: " + getModel() + ", max speed: "
                + getMaxSpeed() + " km/h.");
    }
}
