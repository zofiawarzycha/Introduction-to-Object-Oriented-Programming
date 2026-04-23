import java.time.LocalDate;

public class Tester {
    public static void main(String[] args) {
        Library library = new Library();

        LibraryItem book1 = new Book("Harry Potter", 2000, 456, "J.K.Rowling");
        LibraryItem book2 = new Book("The Four Agreements", 2010, 178, "Miguel Ruiz");

        LibraryItem magazine1 = new Magazine("Vogue", 2026, 32, 85);
        LibraryItem magazine2 = new Magazine("Wieści z Głowna i Strykowa", 2026, 24, 163);

        LibraryItem comic1 = new ComicBook("Avengers", 2023, 44, "Universal Studios" );
        LibraryItem comic2 = new ComicBook("Supermen", 2024, 56, "Universal Studios" );

        library.registerItem(book1);
        library.registerItem(book2);
        library.registerItem(magazine1);
        library.registerItem(magazine2);
        library.registerItem(comic1);
        library.registerItem(comic2);

        Member customer1 = new Member("Zofia Warzycha", 21, true);
        Member customer2 = new Member("Hanna Szpak", 20, true);
        Member customer3 = new Member("Julia Sadowska", 21, false);

        System.out.println("\nThe display of successful loans:");

        try {
            library.registerLoan(book1, customer1, LocalDate.now(), 7);
            library.registerLoan(magazine1, customer1, LocalDate.now(), 14);
            library.registerLoan(comic1, customer2, LocalDate.now(), 21);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nThe summary of loans:");
        library.summaryOfBorrowedItems();

        System.out.println("\nThe list of members:");
        library.allMembersSorted();

        System.out.println("\nThe display of unsuccessful loans:");
         try {
             System.out.println("An inactive member:");
             library.registerLoan(book2, customer3, LocalDate.now(), 7);
         } catch (Exception e) {
             System.out.println("Error: " + e.getMessage());
         }

         try {
             System.out.println("\nA loaned book:");
             library.registerLoan(book1, customer2, LocalDate.now(), 14);
         } catch (Exception e) {
             System.out.println("Error: " + e.getMessage());
         }

         try {
             System.out.println("\nAn unavailable book:");
             comic2.setAvailable(false);
             library.registerLoan(comic2, customer2, LocalDate.now(), 21);
         } catch (Exception e) {
             System.out.println("Error: " + e.getMessage());
         }

         System.out.println("\nThe summary of loans (before returning):");
         library.summaryOfBorrowedItems();

         System.out.println("\nThe process of returning occured!");
         library.returnItem(book1);

         System.out.println("\nThe summary of loans (after returning):");
         library.summaryOfBorrowedItems();
    }
}
