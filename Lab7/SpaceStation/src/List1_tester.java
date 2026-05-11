public class List1_tester {

    public static void main(String[] args) {

        CrewMember[] stationCrew = new CrewMember[10];

        stationCrew[0] = new CrewMember("Igor Stelmach", 21, Role.SCIENTIST, "Astrophysics", 747);
        stationCrew[1] = new CrewMember("Hanna Szpak", 20, Role.ENGINEER, "Nuclear physics", 668);
        stationCrew[2] = new CrewMember("Sebastian Kucharski", 22, Role.COMMANDER, "Organizational management", 9965);

        int totalAge = 0;
        double totalHours = 0.0;
        int activeStationCrewCount = 0;

        System.out.println("Station crew profiles:");

        for (int i = 0; i < stationCrew.length; i++) {
            if (stationCrew[i] != null) {
                stationCrew[i].printProfile();
                totalAge += stationCrew[i].getAge();
                totalHours += stationCrew[i].getMissionHours();
                activeStationCrewCount++;
            }
        }
        double averageAge = (double) totalAge / activeStationCrewCount;
        double averageHours = totalHours / activeStationCrewCount;

        System.out.println("\nAverage age of the crew: " + averageAge);
        System.out.println("Average hours of the crew: " + averageHours);

    }
}
