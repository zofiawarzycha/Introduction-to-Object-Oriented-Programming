import java.util.UUID;

public class Officer {

    private UUID id;
    private String name;
    private String rank;
    private String department;
    private int yearsOfExperience;

    public Officer(String name, String rank, String department, int yearsOfExperience) {
        if (yearsOfExperience < 0) {
            throw new IllegalArgumentException("Years of experience cannot be negative. Got: " + yearsOfExperience);
        }
        this.id = UUID.randomUUID();
        this.name = name;
        this.rank = rank;
        this.department = department;
        this.yearsOfExperience = yearsOfExperience;
    }

    public UUID getId()               { return id; }
    public String getName()           { return name; }
    public String getRank()           { return rank; }
    public String getDepartment()     { return department; }
    public int getYearsOfExperience() { return yearsOfExperience; }

    public void setYearsOfExperience(int yearsOfExperience) {
        if (yearsOfExperience < 0) {
            throw new IllegalArgumentException("Years of experience cannot be negative. Got: " + yearsOfExperience);
        }
        this.yearsOfExperience = yearsOfExperience;
    }
}
