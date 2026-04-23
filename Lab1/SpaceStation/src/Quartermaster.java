public class Quartermaster {

    public static void main(String[] args) {

        CrewMember member1 = new CrewMember("Julia Sadowska", 21, Role.ENGINEER, "IT", 666);
        CrewMember member2 = new CrewMember("Maja Kaczmarek", 21, Role.PILOT, "Lead Pilot", 1244);

        member1.distributeOxygen(4);
        member2.distributeOxygen(2);

    }
}
