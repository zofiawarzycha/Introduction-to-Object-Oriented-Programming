import java.util.List;
import java.util.ArrayList;

public class SmartwatchTester {

    public static void main(String[] args) {

        List<Smartwatch> watches = new ArrayList<>();

        AndroidWatch samsungWatch = AndroidWatch.create("SWA-2026-001", "123456789", WatchProducer.SAMSUNG);
        AndroidWatch garminWatch = AndroidWatch.create("GWA-2026-002", "987654321", WatchProducer.GARMIN);
        AppleWatch appleWatch = AppleWatch.create("AWA-2026-003", "111222333", WatchProducer.APPLE);

        watches.add(samsungWatch);
        watches.add(garminWatch);
        watches.add(appleWatch);

        System.out.println(samsungWatch);
        System.out.println();

        samsungWatch.charge(15);

        samsungWatch.connectWifi();
        samsungWatch.connectBluetooth();

        samsungWatch.startWorkout("Running");
        samsungWatch.stopWorkout();

        samsungWatch.receiveNotification("Meeting at 14:00");

        System.out.println();
        System.out.println(samsungWatch);
        System.out.println();

        System.out.println(appleWatch);
        System.out.println();

        appleWatch.charge(20);
        appleWatch.connectBluetooth();
        appleWatch.startWorkout("Cycling");
        appleWatch.stopWorkout();
        appleWatch.receiveNotification("Low battery");
        appleWatch.makePayment(49.99);

        System.out.println();
        System.out.println(appleWatch);
        System.out.println();

        System.out.println("Samsung notification history:");
        samsungWatch.showNotificationHistory();

        System.out.println();
        System.out.println("Apple notification history:");
        appleWatch.showNotificationHistory();

        System.out.println();
        samsungWatch.makePayment(15.50);

        System.out.println();
        samsungWatch.disconnectWifi();
        samsungWatch.disconnectBluetooth();

        System.out.println();
        System.out.println("Testing invalid producer for AppleWatch:");
        try {
            AppleWatch invalid = AppleWatch.create("BAD-001", "000000000", WatchProducer.SAMSUNG);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        System.out.println();
        System.out.println("Testing invalid phone number:");
        try {
            AndroidWatch bad = AndroidWatch.create("BAD-002", "12345", WatchProducer.SAMSUNG);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        System.out.println();
        System.out.println("All watches in the list:");
        for (Smartwatch watch : watches) {
            System.out.println(watch);
            System.out.println();
        }
    }
}
