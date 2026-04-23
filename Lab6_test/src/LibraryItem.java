import java.util.UUID;

abstract class LibraryItem implements Borrowable{

    private UUID id;
    private String title;
    private int publicationYear;
    private int numberOfPages;
    private boolean available;

    public LibraryItem(String title, int publicationYear, int numberOfPages) {
        if (title == null || title.trim().isEmpty()) throw new IllegalArgumentException("Title cannot be null or empty");
        if (publicationYear <= 0) throw new IllegalArgumentException("Publication year cannot be negative");
        if (numberOfPages <= 0) throw new IllegalArgumentException("Number of pages must be positive");

        this.id = UUID.randomUUID();
        this.title = title;
        this.publicationYear = publicationYear;
        this.numberOfPages = numberOfPages;
        this.available = true;
    }
    public UUID getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public int getPublicationYear() {
        return publicationYear;
    }
    public int getNumberOfPages() {
        return numberOfPages;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }
    @Override
    public String toString() {
        return "ID: " + id + ", title: " + title + ", publication year: " + publicationYear + ", number of pages: "
                + numberOfPages;
    }
}
