public class Scientist extends CrewMember {

    private String researchTopic;

    public Scientist(String name, int age, String specialization, double missionHours, String researchTopic) {
        super(name, age, Role.SCIENTIST, specialization, missionHours);
        this.researchTopic = researchTopic;
    }
    public String getResearchTopic() {
        return researchTopic;
    }

    public void conductExperiment() {
        System.out.println(getName() + " is conducting a groundbreaking experiment on " + researchTopic + ".");
    }
}