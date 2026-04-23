public class AppleWatch extends Smartwatch implements Payable, Chargeable {

    private AppleWatch(String serialNumber, String pairedPhoneNumber) {
        super(serialNumber, pairedPhoneNumber, WatchProducer.APPLE);
    }

    public static AppleWatch create(String serialNumber, String pairedPhoneNumber, WatchProducer producer) {
        validateInput(serialNumber, pairedPhoneNumber);

        if (producer != WatchProducer.APPLE) {
            throw new IllegalArgumentException("AppleWatch must have producer APPLE, got: " + producer);
        }

        return new AppleWatch(serialNumber, pairedPhoneNumber);
    }

    @Override
    public void charge(int percent) {
        System.out.println("Apple Watch charging via MagSafe charger.");
        batteryLevel += percent;
        if (batteryLevel > 100) {
            batteryLevel = 100;
        }
        System.out.println("Charging... Battery is now at " + batteryLevel + "%.");
    }

    @Override
    public void makePayment(double amount) {
        System.out.println("Apple Watch making payment of " + amount + " via Apple Pay.");
    }

    @Override
    public String getSystem() {
        return "watchOS";
    }
}