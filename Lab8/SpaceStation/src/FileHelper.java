import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHelper {

    // ---------------------------------------------------------------
    // CREW MEMBERS
    // ---------------------------------------------------------------

    /**
     * Reads crew member data from a CSV file.
     * Expected row format: name,age,role,specialization,missionHours
     * First row is treated as a header and skipped.
     *
     * @param filename path to the CSV file
     * @return list of CrewMember objects
     * @throws IllegalArgumentException if the file does not exist or a row is malformed
     */
    public static ArrayList<CrewMember> loadCrewMembersCSV(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            throw new IllegalArgumentException(
                    "File not found: " + filename);
        }

        ArrayList<CrewMember> result = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            // skip header line
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            int lineNumber = 1;
            while (scanner.hasNextLine()) {
                lineNumber++;
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(",");
                if (parts.length != 5) {
                    throw new IllegalArgumentException(
                            "Invalid row at line " + lineNumber
                                    + ": expected 5 fields, got " + parts.length
                                    + " -> \"" + line + "\"");
                }

                try {
                    String name          = parts[0].trim();
                    int age              = Integer.parseInt(parts[1].trim());
                    Role role            = Role.valueOf(parts[2].trim().toUpperCase());
                    String specialization = parts[3].trim();
                    double missionHours  = Double.parseDouble(parts[4].trim());

                    result.add(new CrewMember(name, age, role,
                            specialization, missionHours));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException(
                            "Number format error at line " + lineNumber
                                    + ": " + e.getMessage());
                } catch (IllegalArgumentException e) {
                    // re-throw with line context if it's a Role parse error
                    throw new IllegalArgumentException(
                            "Data error at line " + lineNumber
                                    + ": " + e.getMessage());
                }
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(
                    "Could not read file: " + filename + " -> " + e.getMessage());
        }

        return result;
    }

    /**
     * Saves a crew report (statistics) to a text file.
     */
    public static void saveCrewReport(String filename,
                                      ArrayList<CrewMember> crew) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {

            writer.println("========================================");
            writer.println("        SPACE STATION CREW REPORT       ");
            writer.println("========================================");
            writer.println("Total crew members: " + crew.size());
            writer.println();

            // average age
            double avgAge = crew.stream()
                    .mapToInt(CrewMember::getAge)
                    .average()
                    .orElse(0);
            writer.printf("Average age: %.2f%n", avgAge);

            // average mission hours
            double avgHours = crew.stream()
                    .mapToDouble(CrewMember::getMissionHours)
                    .average()
                    .orElse(0);
            writer.printf("Average mission hours: %.2f%n", avgHours);

            // count per role
            writer.println();
            writer.println("Crew members per role:");
            for (Role role : Role.values()) {
                long count = crew.stream()
                        .filter(c -> c.getRole() == role)
                        .count();
                if (count > 0) {
                    writer.printf("  %-12s : %d%n", role, count);
                }
            }

            writer.println();
            writer.println("--- Individual profiles ---");
            for (CrewMember c : crew) {
                writer.printf("  %-25s | age: %2d | role: %-10s | hours: %.1f%n",
                        c.getName(), c.getAge(), c.getRole(), c.getMissionHours());
            }

            writer.println("========================================");

        } catch (IOException e) {
            System.out.println("Error saving crew report: " + e.getMessage());
        }
    }

    public static ArrayList<Supply> loadSuppliesCSV(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            throw new IllegalArgumentException(
                    "File not found: " + filename);
        }

        ArrayList<Supply> result = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            int lineNumber = 1;
            while (scanner.hasNextLine()) {
                lineNumber++;
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(",");
                if (parts.length != 3) {
                    throw new IllegalArgumentException(
                            "Invalid row at line " + lineNumber
                                    + ": expected 3 fields, got " + parts.length
                                    + " -> \"" + line + "\"");
                }

                try {
                    String name       = parts[0].trim();
                    int quantity      = Integer.parseInt(parts[1].trim());
                    BigDecimal cost   = new BigDecimal(parts[2].trim());

                    result.add(new Supply(name, quantity, cost, true));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException(
                            "Number format error at line " + lineNumber
                                    + ": " + e.getMessage());
                }
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(
                    "Could not read file: " + filename + " -> " + e.getMessage());
        }

        return result;
    }

    public static void saveSuppliesReport(String filename,
                                          ArrayList<Supply> supplies) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {

            writer.println("========================================");
            writer.println("      SPACE STATION SUPPLIES REPORT     ");
            writer.println("========================================");
            writer.printf("%-22s | %5s | %10s | %12s%n",
                    "Name", "Qty", "Unit cost", "Total cost");
            writer.println("--------------------------------------------------");

            BigDecimal grandTotal = BigDecimal.ZERO;
            for (Supply s : supplies) {
                BigDecimal total = s.getTotalPrice();
                grandTotal = grandTotal.add(total);
                writer.printf("%-22s | %5d | %10.2f | %12.2f%n",
                        s.getName(), s.getQuantity(),
                        s.getCost(), total);
            }

            writer.println("--------------------------------------------------");
            writer.printf("%-22s   %5s   %10s   %12.2f%n",
                    "TOTAL", "", "", grandTotal);
            writer.println("========================================");

        } catch (IOException e) {
            System.out.println("Error saving supplies report: " + e.getMessage());
        }
    }
}
