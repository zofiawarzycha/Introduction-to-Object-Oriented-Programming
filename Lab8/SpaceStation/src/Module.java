import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

public class Module {

    private String name;
    private CrewMember[] crewMembers;
    private int maxCapacity;

    public Module(int maxCapacity) {
        this("Unnamed Module", maxCapacity);
    }

    public Module(String name, int maxCapacity) {
        if (maxCapacity <= 0) {
            throw new IllegalArgumentException(
                    "Module capacity must be greater than zero. Got: " + maxCapacity);
        }
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.crewMembers = new CrewMember[maxCapacity];
    }

    public void addCrewMember(CrewMember newMember) throws ModuleFullException {
        for (int i = 0; i < crewMembers.length; i++) {
            if (crewMembers[i] == null) {
                crewMembers[i] = newMember;
                System.out.println(newMember.getName() + " added to module \"" + name + "\".");
                return;
            }
        }
        throw new ModuleFullException(
                "Cannot add " + newMember.getName()
                        + ". Module \"" + name + "\" is full (capacity: " + maxCapacity + ").");
    }

    public void removeCrewMember(UUID targetId) {
        for (int i = 0; i < crewMembers.length; i++) {
            if (crewMembers[i] != null && crewMembers[i].getId().equals(targetId)) {
                System.out.println("Removed " + crewMembers[i].getName()
                        + " from module \"" + name + "\".");
                crewMembers[i] = null;
                return;
            }
        }
        System.out.println("Crew member not found in module \"" + name + "\".");
    }

    public void saveCrewToCSV() {
        String filename = name.toLowerCase().replace(" ", "_") + "_crew.csv";

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("id,name,role,specialization,missionHours");

            for (CrewMember c : crewMembers) {
                if (c != null) {
                    writer.printf("%s,%s,%s,%s,%.1f%n",
                            c.getId(),
                            c.getName(),
                            c.getRole(),
                            c.getSpecialization(),
                            c.getMissionHours());
                }
            }

            System.out.println("Module crew saved to: " + filename);

        } catch (IOException e) {
            System.out.println("Error saving module crew: " + e.getMessage());
        }
    }

    public String getName()       { return name; }
    public int getMaxCapacity()   { return maxCapacity; }

    public int getCurrentSize() {
        int count = 0;
        for (CrewMember c : crewMembers) {
            if (c != null) count++;
        }
        return count;
    }
}
