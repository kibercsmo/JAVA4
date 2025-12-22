package main.java.library;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static java.time.LocalDateTime.now;

public class Library {
    private ArrayList<Book> books;
    private OperationLog operationLog;
    Library() {
        books = new ArrayList<Book>();
        operationLog = new OperationLog();
    }
    public static class OperationLog{
        public class LogEntry {
            private OperationType type;
            private LocalDateTime timestamp;
            private String descriprtion;

            LogEntry(OperationType type, String descriprtion){
                this.type = type;
                this.descriprtion = descriprtion;
                this.timestamp = now();
            }

            public OperationType getOperationType(){return type;}
            public LocalDateTime getOperationTimestamp(){return timestamp;}
            public String getOperationDescription(){return descriprtion;}

            @Override
            public String toString() {
                return "Type: " + type + "\n" +
                        "timestapm: " + timestamp + "\n" +
                        "description: " + descriprtion + "\n";
            }
        }

        public enum OperationType{
            ADD_BOOK, BORROW, RETURN;
        }

        private ArrayList<LogEntry> entries= new ArrayList<LogEntry>();
        public void addEntry(OperationType type, String descriprtion){
            entries.add(new LogEntry(type, descriprtion));
        }

        public ArrayList<LogEntry> getEntries(){return entries;}
        public void printLog(){
            System.out.println("Logs: ");
            for(LogEntry entry : entries){
                System.out.println(entry);
            }
            System.out.println("=+=------------------------------=+= \n");
        }
    }

    public OperationLog getOperationLog(){return operationLog;}

    public void addBook(Book book){
        books.add(book);
        operationLog.addEntry(OperationLog.OperationType.BORROW,"Book added: \n" + "id - " + book.getId() + "\n" + "name - " + book.getTitle() + "\n" + "author - " + book.getAuthor() + "\n");
    }
    public void findBookById(int id){
        for(Book book: books){
            if(book.getId() == id) {
                System.out.println(book + "\n");
                return;
            }
        }
        System.out.println("NULl \n");
    }

    public void findBooksByAuthor(String author){
        System.out.println("Books by the author " + author + " : ");
        for(Book book: books){
            if(book.getAuthor().equals(author)) {
                System.out.println(book);
            }
        }
        System.out.println("=+=-----------------------------=+= \n");
    }

    public void borrowBook(int id){
        for (Book book : books){
            if(book.getId() == id && book.getAvailable()) {
                book.available = false;
                System.out.println("All ok");
                operationLog.addEntry(OperationLog.OperationType.RETURN,"Book borrowed: \n" + "id - " + book.getId() + "\n" + "name - " + book.getTitle() + "\n" + "author - " + book.getAuthor() + "\n");
                return;
            }
        }
        System.out.println("Nein");
    }

    public void returnBook(int id){
        for (Book book : books){
            if(book.getId() == id && !book.getAvailable()){
                book.available = true;
                System.out.println("All ok");
                operationLog.addEntry(OperationLog.OperationType.ADD_BOOK,"Book returned: \n" + "id - " + book.getId() + "\n" + "name - " + book.getTitle() + "\n" + "author - " + book.getAuthor() + "\n");
                return;
            }
        }
        System.out.println("Nein");
    }

    public void findBooksAvailable() {
        System.out.println("Available books: ");
        for (Book book : books) {
            if (book.getAvailable()) {
                System.out.println(book);
            }
        }
        System.out.println("=+=-----------------------------=+= \n");
    }
}

