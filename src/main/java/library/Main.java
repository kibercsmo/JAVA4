package main.java.library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Book(1,"War and peace volumes 1-2 ", "L.N.Tolstoy",1869, "978-5-7-090335-2"));
        library.addBook(new Book(2,"War and peace volumes 3-4", "L.N.Tolstoy",1869, "978-5-7-090335-2"));
        library.addBook(new Book(3,"The Hitchhiker's Guide to the galaxy", "A.Douglas",1869, "978-5-7-090335-2"));

        library.findBookById(1);
        library.findBookById(4);

        library.findBooksByAuthor("L.N.Tolstoy");

        library.returnBook(1);
        library.returnBook(2);
        library.returnBook(3);

        library.findBooksAvailable();

        library.borrowBook(2);

        library.findBooksAvailable();

        library.getOperationLog().printLog();
    }
}