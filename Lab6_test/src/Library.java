import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {

    private List<LibraryItem> items = new ArrayList<LibraryItem>();
    private List<Member> members = new ArrayList<>();
    private List<Loan> loans = new ArrayList<>();

    public void registerItem(LibraryItem item) {
        items.add(item);
    }
    public void registerMember(Member member) {
        members.add(member);
    }
    public void registerLoan(LibraryItem item, Member member, LocalDate loanDate, int days) throws MemberIsNotActiveException, ItemAlreadyLoanedException, ItemIsUnavailableException{
        if (!member.isActiveStatus()) {
            throw new MemberIsNotActiveException("Member: " + member + " is not active!");
        }
        for (Loan l : loans) {
            if (l.getItem().getId().equals(item.getId())) {
                throw new ItemAlreadyLoanedException("Item: " + item + " is already loaned!");

            }
        }
        if (!item.isAvailable()) {
            throw new ItemIsUnavailableException("Item: " + item + " is not available!");
        }

        Loan loan = new Loan(item, member, loanDate, days);
        item.setAvailable(false);
        loans.add(loan);

        System.out.println("Loan successfull: " + loan.toString());
    }
    public void returnItem(LibraryItem item) {
        if (item.isAvailable()) {
            loans.removeIf(loan -> loan.getItem().getId().equals(item.getId()));
            item.setAvailable(true);
            System.out.println("Return successfull:" + item.toString());
        }
    }
    public void summaryOfBorrowedItems() {
        for (Loan loan : loans) {
            System.out.println(loan.getItem().getTitle() + ", " + loan.getMember().getFullName() +
                    ", " + loan.getLoanDate() + ", " + loan.getDays());
        }
    }
    public void allMembersSorted() {

        Map<Member, Integer> loanCounts = new HashMap<>();

        for (Member member : members) {
            loanCounts.put(member, 0);
        }
        for (Loan loan : loans) {
            Member m = loan.getMember();
            loanCounts.put(m, loanCounts.getOrDefault(m, 0) + 1);
        }
        List<Map.Entry<Member, Integer>> sortedList = new ArrayList<>(loanCounts.entrySet());
        sortedList.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        for (Map.Entry<Member, Integer> entry : sortedList) {
            System.out.println(entry.getKey().getFullName() + ", " + entry.getValue());
        }
    }
}
