public class List3_tester {

    public static void main(String[] args) {

        Engineer chiefEngineer = new Engineer("Zofia Warzycha", 35, "ship maintenance", 1500.5, "axe");
        CommandOfficer captain = new CommandOfficer("Michał Michałowski", "captain", "command", 25, 10);

        System.out.println("\n---------------Personnel info:");

        chiefEngineer.printProfile();
        chiefEngineer.repairShip();

        System.out.println();

        captain.issueOrder("Prepare the ship for war.");

        System.out.println("\n------------System of access cards:");

        AccessCard basicCard = new AccessCard("level 2", chiefEngineer.getName());
        PremiumAccessCard vipCard = new PremiumAccessCard("level 10", captain.getName(), "AllInclusive service");

        System.out.println(basicCard);
        System.out.println(vipCard);

    }
}