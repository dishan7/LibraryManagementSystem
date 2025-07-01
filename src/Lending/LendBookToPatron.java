package Lending;

import Book.Book;
import Inventory.Inventory;
import Patron.Patron;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LendBookToPatron {
    private HashMap<Patron, HashSet<Book>> bookIssueDetails;
    private HashMap<Patron, HashSet<Book>> bookIssueDetailsHistory;

    public LendBookToPatron() {
        bookIssueDetails = new HashMap<>();
        bookIssueDetailsHistory = new HashMap<>();
    }

    public void lendBookToPatron(Patron patron,  Book book, Inventory inventory) {
        if(!inventory.isAvailable(book)){
            System.out.println("Book is not available");
            return;
        }
        if(!bookIssueDetails.containsKey(patron)) {
            bookIssueDetails.put(patron, new HashSet<>());
            bookIssueDetailsHistory.put(patron, new HashSet<>());
        }
        bookIssueDetails.get(patron).add(book);
        bookIssueDetailsHistory.get(patron).add(book);
        inventory.removeOneBook(book);
        inventory.printInventoryDetails();
    }

    public void returnBookToLibrary(Patron patron,  Book book, Inventory inventory) {
        if(!patronHasBook(patron, book)){
            System.out.println("Patron does not have book to return");
            return;
        }
        bookIssueDetails.get(patron).remove(book);
        inventory.addOneBook(book);
        inventory.printInventoryDetails();
    }

    public HashMap<Patron, HashSet<Book>> getBookIssueDetails() {
        return bookIssueDetails;
    }

    public void setBookIssueDetails(HashMap<Patron, HashSet<Book>> bookIssueDetails) {
        this.bookIssueDetails = bookIssueDetails;
    }

    public HashMap<Patron, HashSet<Book>> getBookIssueDetailsHistory() {
        return bookIssueDetailsHistory;
    }

    public void setBookIssueDetailsHistory(HashMap<Patron, HashSet<Book>> bookIssueDetailsHistory) {
        this.bookIssueDetailsHistory = bookIssueDetailsHistory;
    }

    public boolean patronHasBook(Patron patron, Book book){
        if(bookIssueDetails.containsKey(patron) && bookIssueDetails.get(patron).contains(book)) {
            return true;
        }
        return false;
    }

    public HashSet<Book> getBooksIssuedByPatron(Patron patron){
        return bookIssueDetailsHistory.get(patron);
    }

    public void printLendingDetails() {
        for(Patron patron : bookIssueDetails.keySet()){
            patron.printPatronDetails();
            for(Book book : bookIssueDetails.get(patron)){
                book.printBookDetails();
            }
        }
        System.out.println("History details: ");
        for(Patron patron : bookIssueDetailsHistory.keySet()){
            patron.printPatronDetails();
            for(Book book : bookIssueDetailsHistory.get(patron)){
                book.printBookDetails();
            }
        }
    }
}
