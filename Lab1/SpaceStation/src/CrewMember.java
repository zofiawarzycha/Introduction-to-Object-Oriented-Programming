public class CrewMember {

    private String name;
    private int age;
    private Role role;
    private String specialization;
    private double missionHours;

    public CrewMember() {
        name = "Unknown";
        age = 0;
        role = Role.UNKNOWN;
        specialization = "Unknown";
        missionHours = 0.0;
    }

    public CrewMember(String name, int age, Role role, String specialization, double missionHours) {
        this.name = name;
        this.age = age;
        this.role = role;
        this.specialization = specialization;
        this.missionHours = missionHours;

    }
    public void printProfile () {
        System.out.println("Hello! Meet " + this.name + ", a " + this.age + "-year-old " +
                this.role + ". This crew member specializes in " + this.specialization +
                " and has already completed " + this.missionHours + " mission hours.");
    }

    public void distributeOxygen(int dailyDistributions) {

        int dailyOxygen;

        if (this.missionHours > 1000) {
            dailyOxygen = 3;
        } else {
            dailyOxygen = 2;
        }

        double perDistribution = (double) dailyOxygen / dailyDistributions;

        System.out.println(this.name + " needs " + dailyOxygen +
                " oxygen units daily, which means " + perDistribution +
                " oxygen units per distribution.");
    }

    public double getAge() {
        return this.age;
    }

    public double getMissionHours() {
        return this.missionHours;
    }
}
