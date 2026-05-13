import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class List6_tester {

    public static void main(String[] args) {

        List<CrewMember> crew = new ArrayList<>();

        crew.add(new CrewMember("Sebastian Kucharski", 22, Role.COMMANDER, "Organizational management", 9965.0));
        crew.add(new Engineer("Zofia Warzycha", 21, "Ship maintenance", 1500.5, "axe"));
        crew.add(new Scientist("Igor Stelmach", 21, "Astrophysics", 747.0, "dark matter"));
        crew.add(new Pilot("Stanisław Błaszczyk", 74, "Long-range navigation", 850.5, 1200));
        crew.add(new Medic("Hanna Szpak", 20, "Emergency medicine", 668.0, "surgery"));
        crew.add(new Engineer("Michał Michałowski", 40, "Electrical systems", 3100.0, "multimeter"));


        System.out.println("\n------------Crew sorted by age (ascending):");
        Collections.sort(crew);
        for (CrewMember m : crew) {
            System.out.println(m.getName() + ", age: " + m.getAge()
                    + ", role: " + m.getRole()
                    + ", hours: " + m.getMissionHours());
        }

        System.out.println("\n------------Crew sorted by role (desc) and mission hours (asc):");
        crew.sort(new CrewMemberRoleHoursComparator());
        for (CrewMember m : crew) {
            System.out.println(m.getName() + ", role: " + m.getRole()
                    + ", hours: " + m.getMissionHours());
        }

        System.out.println("\n------------Supply usage and total costs:");

        Supply oxygenTank = new Supply("Oxygen Tank",  10, new BigDecimal("49.99"),  true);
        Supply medKit     = new Supply("Medical Kit",   4, new BigDecimal("120.00"), true);
        Supply spacesuit  = new Supply("Spacesuit",     2, new BigDecimal("8500.00"), false);

        List<Supply> supplies = new ArrayList<>();
        supplies.add(oxygenTank);
        supplies.add(medKit);
        supplies.add(spacesuit);

        try {
            crew.get(0).useSupply(oxygenTank);
        } catch (InvalidSupplyException e) {
            System.out.println("Supply error: " + e.getMessage());
        }

        try {
            crew.get(0).useSupply(medKit);
        } catch (InvalidSupplyException e) {
            System.out.println("Supply error: " + e.getMessage());
        }

        try {
            crew.get(0).useSupply(spacesuit);
        } catch (InvalidSupplyException e) {
            System.out.println("Supply error: " + e.getMessage());
        }

        BigDecimal total = BigDecimal.ZERO;
        for (Supply s : supplies) {
            total = total.add(s.getTotalPrice());
            System.out.println(s);
        }
        System.out.println("Total supply expenses: " + total + " USD");

        System.out.println("\n------------Module capacity test:");

        Module engineeringBay = new Module(3);

        try {
            engineeringBay.addCrewMember(crew.get(0));
            engineeringBay.addCrewMember(crew.get(1));
            engineeringBay.addCrewMember(crew.get(2));
            engineeringBay.addCrewMember(crew.get(3)); // should throw
        } catch (ModuleFullException e) {
            System.out.println("Module error: " + e.getMessage());
        }

        System.out.println("\n------------Access card validation test:");

        // Valid card
        AccessCard basicCard = new AccessCard("level 2", "Zofia Warzycha");
        System.out.println(basicCard);

        // Invalid issue date - in the past
        try {
            AccessCard pastCard = new AccessCard("level 1", "Hanna Szpak",
                    LocalDate.now().minusDays(5));
        } catch (InvalidAccessCardDateException e) {
            System.out.println("Access card error: " + e.getMessage());
        }

        PremiumAccessCard vipCard = new PremiumAccessCard("level 10", "Michał Michałowski", "AllInclusive service");
        System.out.println(vipCard);

        try {
            PremiumAccessCard badPremium = new PremiumAccessCard("level 5", "Sebastian Kucharski",
                    "Command deck access", LocalDate.now().minusMonths(2));
        } catch (InvalidAccessCardDateException e) {
            System.out.println("Premium card error: " + e.getMessage());
        }

        System.out.println("\n------------Constructor validation test:");

        try {
            CrewMember invalid = new CrewMember("Igor Stelmach", -5, Role.SCIENTIST, "Astrophysics", 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Constructor error: " + e.getMessage());
        }

        try {
            Supply badSupply = new Supply("Broken item", -1, new BigDecimal("10.00"), true);
        } catch (IllegalArgumentException e) {
            System.out.println("Supply error: " + e.getMessage());
        }

        try {
            Module tinyModule = new Module(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Module error: " + e.getMessage());
        }
    }
}