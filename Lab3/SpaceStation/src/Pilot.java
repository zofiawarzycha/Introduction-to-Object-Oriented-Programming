public class Pilot extends CrewMember {

    private int flightHours;

    public Pilot(String name, int age, String specialization, double missionHours, int flightHours) {
        super(name, age, Role.PILOT, specialization, missionHours);
        this.flightHours = flightHours;
    }
    public int getFlightHours() {
        return flightHours;
    }

    public void flyShip() {
        System.out.println(getName() + " is flying the ship! They have " + flightHours + " hours of flight experience.");
    }
}