public class ComicBook extends LibraryItem{

    private String illustrator;

    public ComicBook(String title, int publicationYear, int numberOfPages, String illustrator) {

        super(title, publicationYear, numberOfPages);
        if (illustrator == null || illustrator.trim().isEmpty()) throw new IllegalArgumentException("Illustrator cannot be empty!");
        this.illustrator = illustrator;
    }
    @Override
    public String toString() {
        return super.toString() + ", Type: Comic Book, Illustrator: " + illustrator;
    }
}
