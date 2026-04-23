public class Book extends LibraryItem {

    private String author;

    public Book(String title, int publicationYear, int numberOfPages, String author) {

        super(title, publicationYear, numberOfPages);
        this.author = author;
        }

        @Override
        public String toString() {
        return super.toString() + ", Author: " + author;

    }
}
