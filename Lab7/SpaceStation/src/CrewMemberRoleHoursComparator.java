import java.util.Comparator;

public class CrewMemberRoleHoursComparator implements Comparator<CrewMember> {

    @Override
    public int compare(CrewMember a, CrewMember b) {
        int roleCmp = b.getRole().compareTo(a.getRole());
        if (roleCmp != 0) {
            return roleCmp;
        }
        return Double.compare(a.getMissionHours(), b.getMissionHours());
    }
}
