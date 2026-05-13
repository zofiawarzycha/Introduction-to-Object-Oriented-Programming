import java.util.UUID;

public class CrewMember implements Comparable<CrewMember> {

    private UUID id;
    private String name;
    private int age;
    private Role role;
    private String specialization;
    private double missionHours;

    public CrewMember() {
        this.id = UUID.randomUUID();
        this.name = "Unknown";
        this.age = 0;
        this.role = Role.UNKNOWN;
        this.specialization = "Unknown";
        this.missionHours = 0.0;
    }

    public CrewMember(String name, int age, Role role, String specialization, double missionHours) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative. Got: " + age);
        }
        if (missionHours < 0) {
            throw new IllegalArgumentException("Mission hours cannot be negative. Got: " + missionHours);
        }
        this.id = UUID.randomUUID();
        this.name = name;
        this.age = age;
        this.role = role;
        this.specialization = specialization;
        this.missionHours = missionHours;
    }


    public void useSupply(Supply supply) throws InvalidSupplyException {
        if (!supply.isConsumable()) {
            throw new InvalidSupplyException(
                    "Supply \"" + supply.getName() + "\" is not consumable and cannot be used by " + this.name + "."
            );
        }
        System.out.println(this.name + " used supply: " + supply.getName()
                + " (quantity: " + supply.getQuantity() + ").");
    }


    @Override
    public int compareTo(CrewMember other) {
        return Integer.compare(this.age, other.age);
    }


    public void printProfile() {
        System.out.println("Hello! Meet " + this.name + ", a " + this.age + "-year-old " +
                this.role + ". This crew member specializes in " + this.specialization +
                " and has already completed " + this.missionHours + " mission hours.");
    }

    public void distributeOxygen(int dailyDistributions) {
        int dailyOxygen = (this.missionHours > 1000) ? 3 : 2;
        double perDistribution = (double) dailyOxygen / dailyDistributions;
        System.out.println(this.name + " needs " + dailyOxygen +
                " oxygen units daily, which means " + perDistribution +
                " oxygen units per distribution.");
    }

    public UUID getId() { return this.id; }

    public String getName() { return this.name; }

    public void setName(String name) { this.name = name; }

    public int getAge() { return this.age; }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative. Got: " + age);
        }
        this.age = age;
    }

    public Role getRole() { return this.role; }

    public String getSpecialization() { return this.specialization; }

    public double getMissionHours() { return this.missionHours; }

    public void setMissionHours(double missionHours) {
        if (missionHours < 0) {
            throw new IllegalArgumentException("Mission hours cannot be negative. Got: " + missionHours);
        }
        this.missionHours = missionHours;
    }
}
