import java.util.UUID;

public class Module {

    private CrewMember[] crewMembers;
    private int maxCapacity;

    public Module(int maxCapacity) {
        if (maxCapacity <= 0) {
            throw new IllegalArgumentException("Module capacity must be greater than zero. Got: " + maxCapacity);
        }
        this.maxCapacity = maxCapacity;
        this.crewMembers = new CrewMember[maxCapacity];
    }

    public void addCrewMember(CrewMember newMember) throws ModuleFullException {
        for (int i = 0; i < crewMembers.length; i++) {
            if (crewMembers[i] == null) {
                crewMembers[i] = newMember;
                System.out.println(newMember.getName() + " added to module.");
                return;
            }
        }
        throw new ModuleFullException(
                "Cannot add " + newMember.getName() + ". Module is full (capacity: " + maxCapacity + ")."
        );
    }

    public void removeCrewMember(UUID targetId) {
        for (int i = 0; i < crewMembers.length; i++) {
            if (crewMembers[i] != null && crewMembers[i].getId().equals(targetId)) {
                System.out.println("Removed " + crewMembers[i].getName() + " from module.");
                crewMembers[i] = null;
                return;
            }
        }
        System.out.println("Crew member not found in this module.");
    }

    public int getMaxCapacity() { return maxCapacity; }
}
