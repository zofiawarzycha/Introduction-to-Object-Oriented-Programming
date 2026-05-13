public class OperationsOfficer extends Officer {

    private String managedModule;

    public OperationsOfficer(String name, String rank, String department, int yearsOfExperience, String managedModule) {
        super(name, rank, department, yearsOfExperience);
        this.managedModule = managedModule;
    }
    public String getManagedModule() {
        return managedModule;
    }
    public void optimizeResources() {
        System.out.println(getName() + " is optimizing the power grid in the " + managedModule + " module.");
    }
}