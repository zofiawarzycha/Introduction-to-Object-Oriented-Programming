public class CommandOfficer extends Officer {

    private int securityClearanceLevel;

    public CommandOfficer(String name, String rank, String department, int yearsOfExperience, int securityClearanceLevel) {
        super(name, rank, department, yearsOfExperience);
        this.securityClearanceLevel = securityClearanceLevel;
    }
    public int getSecurityClearanceLevel() {
        return securityClearanceLevel;
    }

    public void issueOrder(String order) {
        System.out.println(getRank() + " " + getName() + " issues an order: " + order);
    }
}