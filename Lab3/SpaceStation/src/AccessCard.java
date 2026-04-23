import java.time.LocalDate;

public class AccessCard {

    private String accessLevel;
    private String crewMemberName;
    private LocalDate issueDate;

    public AccessCard(String accessLevel, String crewMemberName) {
        this.accessLevel = accessLevel;
        this.crewMemberName = crewMemberName;
        this.issueDate = LocalDate.now();
    }

    public String getAccessLevel() { return accessLevel; }
    public String getCrewMemberName() { return crewMemberName; }
    public LocalDate getIssueDate() { return issueDate; }

    @Override
    public String toString() {
        return "Access Card of " + crewMemberName + ", level: " + accessLevel + ", issued: " + issueDate + "]";
    }
}