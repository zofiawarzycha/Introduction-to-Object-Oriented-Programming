public class AndroidWatch extends Smartwatch implements Payable, Chargeable {

    private AndroidWatch(String serialNumber, String pairedPhoneNumber, WatchProducer producer) {
        super(serialNumber, pairedPhoneNumber, producer);
    }

    public static AndroidWatch create(String serialNumber, String pairedPhoneNumber, WatchProducer producer) {
        validateInput(serialNumber, pairedPhoneNumber);

        if (producer != WatchProducer.SAMSUNG && producer != WatchProducer.GARMIN
                && producer != WatchProducer.HUAWEI && producer != WatchProducer.XIAOMI) {
            throw new IllegalArgumentException("Producer " + producer + " is not valid for AndroidWatch.");
        }

        return new AndroidWatch(serialNumber, pairedPhoneNumber, producer);
    }

    @Override
    public void charge(int percent) {
        System.out.println(getProducer() + " smartwatch charging via magnetic charger.");
        batteryLevel += percent;
        if (batteryLevel > 100) {
            batteryLevel = 100;
        }
        System.out.println("Charging... Battery is now at " + batteryLevel + "%.");
    }

    @Override
    public void makePayment(double amount) {
        System.out.println(getProducer() + " smartwatch making payment of " + amount + " via Google Pay.");
    }

    @Override
    public String getSystem() {
        return "Wear OS";
    }
}