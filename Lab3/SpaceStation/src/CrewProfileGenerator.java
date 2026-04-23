public class CrewProfileGenerator {

    public static void main(String[] args) {

        CrewMember member1 = new CrewMember();
        CrewMember member2 = new CrewMember("Zofia Warzycha", 21, Role.ENGINEER, "IT", 29.6);

        member1.printProfile();
        System.out.println("");
        member2.printProfile();

    }
}
