import java.time.LocalDate;

public class Loan {

    private LibraryItem item;
    private Member member;
    private LocalDate loanDate;
    private int days;

    public Loan(LibraryItem item, Member member, LocalDate loanDate, int days) {
        this.item = item;
        this.member = member;
        this.loanDate = loanDate;
        this.days = days;
    }
    public LibraryItem getItem() {
        return item;
    }
    public Member getMember() {
        return member;
    }
    public LocalDate getLoanDate() {
        return loanDate;
    }
    public int getDays() {
        return days;
    }
    @Override
    public String toString() {
        return member.getFullName() + " borrowed: " + item.getTitle() + " for " + days + " days";
    }
}
