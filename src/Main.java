import Book.Book;
import Inventory.Inventory;
import Lending.LendBookToPatron;
import Patron.Patron;

public class Main {
    public static void main(String[] args) {
        //Books
        Book book1 = new Book(1, "book1", "Author 1", "xyz", 2011);
        Book book2 = new Book(2, "book2", "Author 2", "xyz", 2011);
        Book book3 = new Book(3, "book3", "Author 3", "xyz", 2011);
        //Patrons
        Patron patron1 = new Patron(1, "Patron1", "test1@email.com");
        Patron patron2 = new Patron(2, "Patron2", "test2@email.com");
        //Inventory
        Inventory inventory = new Inventory();
        inventory.addBook(book1, 1);
        inventory.addBook(book2, 2);
        inventory.addBook(book3, 3);
        //LendBookToPatron
        LendBookToPatron lendBookToPatron = new LendBookToPatron();
        lendBookToPatron.lendBookToPatron(patron1, book1, inventory);
        lendBookToPatron.lendBookToPatron(patron2, book2, inventory);
        lendBookToPatron.lendBookToPatron(patron1, book3, inventory);
        lendBookToPatron.returnBookToLibrary(patron1, book1, inventory);
        lendBookToPatron.returnBookToLibrary(patron2, book3, inventory);
        //print details
        lendBookToPatron.printLendingDetails();
    }
}
