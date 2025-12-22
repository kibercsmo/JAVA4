package main.java.library;

public class Book {

    int id;
    String title;
    String author;
    int year;
    String isbn;
    boolean available;

    Book(int id,String title, String author, int year, String isbn){
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
        available = false;
    }
    public int getId(){return id;};
    public int getYear(){return year;};
    public String getTitle(){return title;};
    public String getAuthor(){return author;};
    public String getISBN(){return isbn;};
    public boolean getAvailable(){return available;};

    public void setAvailable(boolean available){
        this.available = available;
    }

    @Override
    public String toString() {
        return "[ID: " + id + " ] " + '"' + title + '"' + " - " + author + " (" + year + ")" + "\n"
                + "ISBN: " + isbn + " | Status: " + available;
    }
}

