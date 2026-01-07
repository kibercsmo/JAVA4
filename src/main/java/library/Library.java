package main.java.library;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private OperationLog operationLog;

    Library(){
        books = new ArrayList<>();
        operationLog = new OperationLog();
    }

    public class OperationLog{

        public class logEntry {
            private operationType type;
            private LocalDateTime timestamp;
            private String description;

            logEntry(operationType type, LocalDateTime timestamp, String description){
                this.type = type;
                this.timestamp = timestamp;
                this.description = description;
            }

            @Override
            public String toString() {
                return "Type: " + type + " |Time: " + timestamp + "\n" +
                        "Описание: " + description;
            }
        }

        public enum operationType {
            ADD_BOOK, BORROW, RETURN
        }

        private ArrayList<logEntry> entries = new ArrayList<>();

        public void addEntry(operationType type, String description){
            entries.add(new logEntry(type, LocalDateTime.now(), description));
        }

        public void printLog() {
            for (logEntry log : entries){
                System.out.println(log);
            }
        }
    }

    public void addBook(Book book){
        books.add(book);
        operationLog.addEntry(OperationLog.operationType.ADD_BOOK,
                "Добавили книгу: " + book.getTitle());
    }

    public int findBookById(int id){
        for (Book book : books){
            if (book.getId() == id){
                System.out.println(book);
                return 0;
            }
        }
        System.out.println("Null");
        return 0;
    }

    public void findBookByAuthor(String author){
        for (Book book: books){
            if(book.getAuthor().equals(author)) {
                System.out.println(book);
            }
        }
    }

    public void borrowBook(int id){
        for (Book book : books){
            if (book.getId() == id){
                book.setAvailable(false);
                operationLog.addEntry(OperationLog.operationType.BORROW,
                        "Взяли книгу: " + book.title + " с ID " + id);
            }
        }
    }

    public void returnBook(int id){
        for (Book book : books){
            if (book.getId() == id){
                book.setAvailable(true);
                operationLog.addEntry(OperationLog.operationType.RETURN,
                        "Вернули книгу: " + book.title + " с ID " + id);
            }
        }
    }

    public void getAvailableBooks(){
        for (Book book : books){
            if (book.available){
                System.out.println(book);
            }
        }
    }

    public void printOperationLog() {
        operationLog.printLog();
    }
}
