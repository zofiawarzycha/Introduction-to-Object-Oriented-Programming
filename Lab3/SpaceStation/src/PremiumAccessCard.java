import java.time.LocalDate;

public class PremiumAccessCard extends AccessCard {

    private LocalDate expirationDate;
    private String specialPrivileges;

    public PremiumAccessCard(String accessLevel, String crewMemberName, String specialPrivileges) {
        super(accessLevel, crewMemberName);
        this.specialPrivileges = specialPrivileges;
        this.expirationDate = LocalDate.now().plusYears(1);
    }

    @Override
    public String toString() {
        return super.toString() + " -> PREMIUM [Expires: " + expirationDate + ", privileges: " + specialPrivileges + "]";
    }
}