public class Engineer extends CrewMember {

    private String favoriteTool;

    public Engineer(String name, int age, String specialization, double missionHours, String favoriteTool) {
        super(name, age, Role.ENGINEER, specialization, missionHours);
        this.favoriteTool = favoriteTool;
    }
    public String getFavoriteTool() {
        return favoriteTool;
    }

    public void repairShip() {
        System.out.println(getName() + " is repairing the ship using a " + favoriteTool + "!");
    }
}