import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SpaceStation {

    private List<Officer> officers;
    private CrewMember[] crewMembers;
    private List<Supply> supplies;
    private Module[][] stationMap;

    public SpaceStation(int maxCrew, int mapRows, int mapCols) {
        this.officers = new ArrayList<>();
        this.crewMembers = new CrewMember[maxCrew];
        this.supplies = new ArrayList<>();
        this.stationMap = new Module[mapRows][mapCols];
    }

    public void addOfficer(Officer officer) {
        this.officers.add(officer);
    }

    public void removeOfficer(UUID targetId) {
        for (int i = officers.size() - 1; i >= 0; i--) {
            if (officers.get(i).getId().equals(targetId)) {
                officers.remove(i);
                System.out.println("Officer removed.");
                return;
            }
        }
    }

    public void addCrewMember(CrewMember member) {
        for (int i = 0; i < crewMembers.length; i++) {
            if (crewMembers[i] == null) {
                crewMembers[i] = member;
                return;
            }
        }
        System.out.println("Station crew capacity is full.");
    }

    public void removeCrewMember(UUID targetId) {
        for (int i = 0; i < crewMembers.length; i++) {
            if (crewMembers[i] != null && crewMembers[i].getId().equals(targetId)) {
                crewMembers[i] = null;
                System.out.println("Crew member removed from station array.");
                return;
            }
        }
    }
}