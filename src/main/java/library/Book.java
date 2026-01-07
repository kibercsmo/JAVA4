package main.java.library;

public class Book {
    int id;
    String title;
    String author;
    int year;
    String isbn;
    Boolean available;

    Book(int id, String title, String author, int year, String isbn){
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
        this.available = true;
    }

    public int getId(){return id;}
    public String getTitle(){return title;}
    public String getAuthor(){return author;}
    public int getYear(){return year;}
    public String getIsbn(){return isbn;}
    public Boolean getAvailable(){return available;}

    public void setAvailable(Boolean available){this.available = available;}

    @Override
    public String toString() {
        return "[ID: " + id + "] " + '"' + title + '"' + " - " + author + " (" + year + ") " + "\n" +
                "ISBN: " + isbn + " | Status: " + available;
    }

}
