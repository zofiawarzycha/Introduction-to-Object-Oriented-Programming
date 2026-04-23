import java.util.UUID;

public class Officer {

    private UUID id;
    private String name;
    private String rank;
    private String department;
    private int yearsOfExperience;

    public Officer(String name, String rank, String department, int yearsOfExperience) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.rank = rank;
        this.department = department;
        this.yearsOfExperience = yearsOfExperience;
    }

    public UUID getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
}