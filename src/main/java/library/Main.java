package main.java.library;

public class Main {
    public static void main(String[] args) {

        Library lib = new Library();

        lib.addBook(new Book(1, "Война и мир",
                "Л.Н. Толстой", 1869, "978-5-17-090335-2"));
        lib.addBook(new Book(2, "Преступление и наказание",
                "Ф.М. Достоевский", 1866, "978-5-17-090336-9"));
        lib.addBook(new Book(3, "Анна Каренина",
                "Л.Н. Толстой", 1877, "978-5-17-090337-6"));

        System.out.println("--------------------");

        lib.findBookById(3);
        lib.findBookById(2);

        System.out.println("--------------------");

        lib.findBookById(4);

        System.out.println("--------------------");

        lib.borrowBook(1);
        lib.borrowBook(2);

        lib.returnBook(1);

        lib.getAvailableBooks();

        System.out.println("--------------------");

        lib.findBookByAuthor("Л.Н. Толстой");

        System.out.println("--------------------");

        lib.printOperationLog();

        System.out.println("--------------------");
    }
}
