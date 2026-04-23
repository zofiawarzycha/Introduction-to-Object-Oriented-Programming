public class Truck extends Vehicle {

    public double loadCapacity;

    public Truck(String brand, String model, double MaxSpeed, double loadCapacity) {
        super(brand, model, MaxSpeed);
        this.loadCapacity = loadCapacity;
    }
    public double getLoadCapacity() {
        return loadCapacity;
    }
    @Override
    public void showInfo() {
        System.out.println("Truck: " + getBrand() + ", model: " + getModel() + ", max speed: "
                + getMaxSpeed() + " km/h, with load capacity: " + getLoadCapacity());
    }
    public void cargoTransport() {
        System.out.println(getBrand() + ", model: " + getModel() + " is a cargo transport.");
    }
}
