import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class List8_tester {

    public static void main(String[] args) {

        System.out.println("1. CREW MEMBERS");

        ArrayList<CrewMember> crew = null;

        try {
            crew = FileHelper.loadCrewMembersCSV("crew_members.csv");
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return;
        }

        System.out.println("\n-- Loaded crew profiles --");
        for (CrewMember c : crew) {
            c.printProfile();
        }

        double avgAge = crew.stream()
                .mapToInt(CrewMember::getAge)
                .average()
                .orElse(0);

        double avgHours = crew.stream()
                .mapToDouble(CrewMember::getMissionHours)
                .average()
                .orElse(0);

        System.out.printf("%nAverage age: %.2f%n", avgAge);
        System.out.printf("Average mission hours: %.2f%n", avgHours);

        System.out.println("\nCrew members per role:");
        Map<Role, Long> perRole = new TreeMap<>();
        for (CrewMember c : crew) {
            perRole.merge(c.getRole(), 1L, Long::sum);
        }
        for (Map.Entry<Role, Long> entry : perRole.entrySet()) {
            System.out.printf("  %-12s : %d%n", entry.getKey(), entry.getValue());
        }

        FileHelper.saveCrewReport("crew_report.txt", crew);
        System.out.println("\nCrew report saved to: crew_report.txt");

        System.out.println("\n2. SUPPLIES");

        ArrayList<Supply> supplies = null;

        try {
            supplies = FileHelper.loadSuppliesCSV("supplies.csv");
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return;
        }

        System.out.println("\n-- Loaded supplies --");
        BigDecimal grandTotal = BigDecimal.ZERO;
        for (Supply s : supplies) {
            BigDecimal total = s.getTotalPrice();
            grandTotal = grandTotal.add(total);
            System.out.printf("  %-22s | qty: %3d | unit: %8.2f | total: %10.2f%n",
                    s.getName(), s.getQuantity(), s.getCost(), total);
        }
        System.out.printf("%nTotal cost of all supplies: %.2f%n", grandTotal);

        FileHelper.saveSuppliesReport("supplies_report.txt", supplies);
        System.out.println("Supplies report saved to: supplies_report.txt");

        System.out.println("\n3. MODULE CREW EXPORT");

        Module scienceLab = new Module("Science Lab", 4);

        try {
            scienceLab.addCrewMember(crew.get(2));
            scienceLab.addCrewMember(crew.get(5));
            scienceLab.addCrewMember(crew.get(3));
        } catch (ModuleFullException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }

        System.out.println("Module \"" + scienceLab.getName()
                + "\" has " + scienceLab.getCurrentSize()
                + "/" + scienceLab.getMaxCapacity() + " crew members.");

        scienceLab.saveCrewToCSV();

        System.out.println("\n4. ERROR HANDLING");

        try {
            FileHelper.loadCrewMembersCSV("missing_file.csv");
        } catch (IllegalArgumentException e) {
            System.out.println("[OK] File missing: " + e.getMessage());
        }

        try {
            FileHelper.loadSuppliesCSV("bad_file.csv");
        } catch (IllegalArgumentException e) {
            System.out.println("[OK] File missing: " + e.getMessage());
        }

        System.out.println("\nALL TASKS COMPLETED");
    }
}
