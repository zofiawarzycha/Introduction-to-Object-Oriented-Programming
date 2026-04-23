import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;

public abstract class Smartwatch implements Connectable, Notifiable, Trackable {

    private String serialNumber;
    private String pairedPhoneNumber;
    private List<String> activityHistory;
    protected int batteryLevel;
    private boolean bluetoothConnected;
    private boolean wifiConnected;
    private List<String> notificationHistory;
    private WatchProducer producer;
    private String currentWorkout;

    protected Smartwatch(String serialNumber, String pairedPhoneNumber, WatchProducer producer) {
        this.serialNumber = serialNumber;
        this.pairedPhoneNumber = pairedPhoneNumber;
        this.producer = producer;
        this.batteryLevel = 60;
        this.bluetoothConnected = false;
        this.wifiConnected = false;
        this.activityHistory = new ArrayList<>();
        this.notificationHistory = new ArrayList<>();
    }

    public static void validateInput(String serialNumber, String pairedPhoneNumber) {
        if (serialNumber == null || serialNumber.isEmpty()) {
            throw new IllegalArgumentException("Serial number cannot be empty.");
        }
        if (pairedPhoneNumber == null || !pairedPhoneNumber.matches("\\d{9}")) {
            throw new IllegalArgumentException("Paired phone number must be a 9-digit number.");
        }
    }

    @Override
    public void connectWifi() {
        this.wifiConnected = true;
        System.out.println(producer + " smartwatch connected to WiFi.");
    }

    @Override
    public void disconnectWifi() {
        this.wifiConnected = false;
        System.out.println(producer + " smartwatch disconnected from WiFi.");
    }

    @Override
    public void connectBluetooth() {
        this.bluetoothConnected = true;
        System.out.println(producer + " smartwatch connected to Bluetooth.");
    }

    @Override
    public void disconnectBluetooth() {
        this.bluetoothConnected = false;
        System.out.println(producer + " smartwatch disconnected from Bluetooth.");
    }

    @Override
    public void startWorkout(String workoutType) {
        this.currentWorkout = workoutType;
        System.out.println("Workout started: " + workoutType);
    }

    @Override
    public void stopWorkout() {
        if (currentWorkout == null) {
            System.out.println("No workout in progress.");
            return;
        }
        String entry = "[" + LocalDateTime.now() + "] Workout completed: " + currentWorkout;
        activityHistory.add(entry);
        System.out.println("Workout stopped.");
        currentWorkout = null;
    }

    @Override
    public void receiveNotification(String message) {
        String entry = "[" + LocalDateTime.now() + "] Notification: " + message;
        notificationHistory.add(entry);
        System.out.println("Notification received: " + message);
    }

    @Override
    public void showNotificationHistory() {
        if (notificationHistory.isEmpty()) {
            System.out.println("No notifications.");
            return;
        }
        for (String n : notificationHistory) {
            System.out.println(n);
        }
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getPairedPhoneNumber() {
        return pairedPhoneNumber;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public boolean isBluetoothConnected() {
        return bluetoothConnected;
    }

    public boolean isWifiConnected() {
        return wifiConnected;
    }

    public List<String> getActivityHistory() {
        return activityHistory;
    }

    public WatchProducer getProducer() {
        return producer;
    }

    public abstract String getSystem();

    @Override
    public String toString() {
        return "Watch Info:\n" +
                "Producer: " + producer + "\n" +
                "System: " + getSystem() + "\n" +
                "Paired Number: " + pairedPhoneNumber + "\n" +
                "Serial Number: " + serialNumber + "\n" +
                "Battery Level: " + batteryLevel + "%\n" +
                "WiFi: " + (wifiConnected ? "Connected" : "Not connected") + "\n" +
                "Bluetooth: " + (bluetoothConnected ? "Connected" : "Not connected") + "\n" +
                "Tracked Activities: " + activityHistory.size() + "\n" +
                "Notifications: " + notificationHistory.size();
    }
}