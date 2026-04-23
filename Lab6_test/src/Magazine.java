public class Magazine extends LibraryItem{

    private int issueNumber;

    public Magazine(String title, int publicationYear, int numberOfPages, int issueNumber) {

        super(title, publicationYear, numberOfPages);

        if (issueNumber <= 0) throw new IllegalArgumentException("Issue number must be positive!");

        this.issueNumber = issueNumber;

    }
    @Override
    public String toString() {
        return super.toString() + " , Type: Magazine, IssueNumber: " + issueNumber;
    }
}
