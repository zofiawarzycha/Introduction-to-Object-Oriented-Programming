public class Commander extends CrewMember {

    private String strategicFocus;

    public Commander(String name, int age, String specialization, double missionHours, String strategicFocus) {
        super(name, age, Role.COMMANDER, specialization, missionHours);
        this.strategicFocus = strategicFocus;
    }

    public String getStrategicFocus() {
        return strategicFocus;
    }

    public void leadMission() {
        System.out.println(getName() + " is leading the mission with a focus on " + strategicFocus + ".");
    }
}