public class VehicleDemo {
    public static void main(String[] args) {

        Vehicle[] vehicles = new Vehicle[6];

        vehicles[0] = new Car("Fiat", "Punto", 170, 5);
        vehicles[1] = new Car("BMW", "E46", 180, 3);
        vehicles[2] = new Bike("CityBike", "ab76", 40, true);
        vehicles[3] = new Bike("BikeCity", "ba67", 44, false);
        vehicles[4] = new Truck("Mercedes", "TRK34", 160, 987);
        vehicles[5] = new Truck("Mercedes", "TRK47", 155, 1010);

        System.out.println("Vehicle profiles:");

        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] != null) {
                vehicles[i].showInfo();

                if (vehicles[i] instanceof Car) {
                    Car myCar = (Car) vehicles[i];
                    myCar.cityDriving();
                } else if (vehicles[i] instanceof Bike) {
                    Bike myBike = (Bike) vehicles[i];
                    myBike.ecoFriendly();
                } else if (vehicles[i] instanceof Truck) {
                    Truck myTruck = (Truck) vehicles[i];
                    myTruck.cargoTransport();
                }
            }
        }
    }
}
