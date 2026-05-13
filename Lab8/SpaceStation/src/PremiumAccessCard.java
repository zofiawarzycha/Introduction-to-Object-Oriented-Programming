import java.time.LocalDate;

public class PremiumAccessCard extends AccessCard {

    private LocalDate expirationDate;
    private String specialPrivileges;

    public PremiumAccessCard(String accessLevel, String crewMemberName, String specialPrivileges) {
        super(accessLevel, crewMemberName);
        this.specialPrivileges = specialPrivileges;
        this.expirationDate = LocalDate.now().plusYears(1);
    }

    public PremiumAccessCard(String accessLevel, String crewMemberName,
                             String specialPrivileges, LocalDate expirationDate)
            throws InvalidAccessCardDateException {
        super(accessLevel, crewMemberName);
        if (expirationDate.isBefore(getIssueDate())) {
            throw new InvalidAccessCardDateException(
                    "Expiration date (" + expirationDate + ") cannot be earlier than issue date (" + getIssueDate() + ")."
            );
        }
        this.specialPrivileges = specialPrivileges;
        this.expirationDate = expirationDate;
    }

    public LocalDate getExpirationDate()  { return expirationDate; }
    public String getSpecialPrivileges()  { return specialPrivileges; }

    @Override
    public String toString() {
        return super.toString() + " -> PREMIUM [Expires: " + expirationDate
                + ", privileges: " + specialPrivileges + "]";
    }
}
