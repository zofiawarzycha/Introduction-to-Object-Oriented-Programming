import java.util.UUID;

public class Module {

    private CrewMember[] crewMembers;
    private int maxCapacity;

    public Module(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.crewMembers = new CrewMember[maxCapacity];
    }

    public void addCrewMember(CrewMember newMember) {
        for (int i = 0; i < crewMembers.length; i++) {
            if (crewMembers[i] == null) {
                crewMembers[i] = newMember;
                System.out.println(newMember.getName() + " added to module.");
                return;
            }
        }
        System.out.println("Module is full!");
    }


    public void removeCrewMember(UUID targetId) {
        for (int i = 0; i < crewMembers.length; i++) {
            if (crewMembers[i] != null && crewMembers[i].getId().equals(targetId)) {
                System.out.println("Removed crew member from module.");
                crewMembers[i] = null;
                return;
            }
        }
        System.out.println("Crew member not found in this module.");
    }
}