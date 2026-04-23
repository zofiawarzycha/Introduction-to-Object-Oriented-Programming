import java.util.UUID;

public class MasterTester {

    public static void main(String[] args) {

        SpaceStation myStation = new SpaceStation(5, 3, 3);
        System.out.println("--- Space Station Initialized ---");

        Officer commander = new Officer("Donald Tusk", "Commander", "Command", 30);
        CrewMember engineer = new CrewMember("Stanisław Błaszczyk", 28, Role.ENGINEER, "Software management", 850.5);

        System.out.println("Officer hired: " + commander.getName());
        System.out.println("ID Badge printed: " + commander.getId());
        System.out.println();

        System.out.println("Crew hired: " + engineer.getName());
        System.out.println("ID Badge printed: " + engineer.getId());
        System.out.println();

        myStation.addOfficer(commander);
        myStation.addCrewMember(engineer);
        System.out.println("--- Personnel added to the Station's main database! ---");
        System.out.println();

        System.out.println("--- Testing the Removal System ---");

        UUID badgeToRemove = engineer.getId();

        System.out.println("Attempting to remove crew member with ID: " + badgeToRemove);

        myStation.removeCrewMember(badgeToRemove);
    }
}