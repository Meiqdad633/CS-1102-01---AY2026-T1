import java.util.*;

class Book {
    String title;
    String author;
    int quantity;

    Book(String t, String a, int q) {
        title = t;
        author = a;
        quantity = q;
    }
}

public class LibrarySystem {
    static Map<String, Book> library = new HashMap<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            showMenu();
            String choice = input.nextLine().trim();

            switch (choice) {
                case "1" -> addBook();
                case "2" -> borrowBook();
                case "3" -> returnBook();
                case "4" -> {
                    System.out.println("Exiting program... Thank you!");
                    running = false;
                }
                default -> System.out.println("Invalid option! Please enter 1–4.");
            }
        }
    }

    // Show menu
    static void showMenu() {
        System.out.println("\n===== Library Menu =====");
        System.out.println("1. Add Books");
        System.out.println("2. Borrow Books");
        System.out.println("3. Return Books");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    // Add new book or update existing
    static void addBook() {
        System.out.print("Enter title: ");
        String title = input.nextLine().trim();
        System.out.print("Enter author: ");
        String author = input.nextLine().trim();
        System.out.print("Enter quantity: ");
        int qty = readInt();

        Book book = library.getOrDefault(title, new Book(title, author, 0));
        book.quantity += qty;
        library.put(title, book);

        System.out.println(library.containsKey(title) ? 
            "Updated existing book quantity." : 
            "New book added successfully.");
    }

    // Borrow a book
    static void borrowBook() {
        System.out.print("Enter book title: ");
        String title = input.nextLine().trim();

        if (!library.containsKey(title)) {
            System.out.println("Book not found in library.");
            return;
        }

        System.out.print("Enter quantity to borrow: ");
        int qty = readInt();

        Book book = library.get(title);
        if (qty > 0 && qty <= book.quantity) {
            book.quantity -= qty;
            System.out.println("Borrowed " + qty + " copy/copies of " + title + ".");
        } else {
            System.out.println("Not enough copies available. Current stock: " + book.quantity);
        }
    }

    // Return a book
    static void returnBook() {
        System.out.print("Enter book title: ");
        String title = input.nextLine().trim();

        if (!library.containsKey(title)) {
            System.out.println("This book does not belong to the library.");
            return;
        }

        System.out.print("Enter quantity to return: ");
        int qty = readInt();

        if (qty > 0) {
            Book book = library.get(title);
            book.quantity += qty;
            System.out.println("Returned " + qty + " copy/copies of " + title + ".");
        } else {
            System.out.println("Quantity must be greater than zero.");
        }
    }

    // Helper method to safely read integer
    static int readInt() {
        while (!input.hasNextInt()) {
            System.out.print("Invalid number, try again: ");
            input.next();
        }
        int number = input.nextInt();
        input.nextLine(); // clear newline
        return number;
    }
}
