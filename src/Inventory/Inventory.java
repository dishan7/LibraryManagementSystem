package Inventory;

import Book.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Inventory {

    private HashMap<Book, Integer> inventory;

    public Inventory() {
        inventory = new HashMap<>();
    }

    public HashMap<Book, Integer> getInventory() {
        return inventory;
    }

    public void setInventory(HashMap<Book, Integer> inventory) {
        this.inventory = inventory;
    }

    public void addBook(Book book, int quantity){
        inventory.put(book, quantity);
    }

    public void addOneBook(Book book){
        inventory.put(book, inventory.get(book) + 1);
    }

    public void removeOneBook(Book book){
        inventory.put(book, inventory.get(book)-1);
    }

    public boolean isAvailable(Book book){
        return inventory.containsKey(book) && inventory.get(book)>0;
    }

    public Book getBooByTitle(String title){
        for (Book book : inventory.keySet()) {
            if(book.getBookName().equals(title)){
                return book;
            }
        }
        return null;
    }

    public List<Book> getBookByAuthor(String author){
        List<Book> booksByAuthor = new ArrayList<>();
        for (Book book : inventory.keySet()) {
            if(book.getBookAuthor().equals(author)){
                booksByAuthor.add(book);
            }
        }
        return booksByAuthor;
    }

    public Book getBookByISBN(String isbn){
        for (Book book : inventory.keySet()) {
            if(book.getISBN().equals(isbn)){
                return book;
            }
        }
        return null;
    }

    public void printInventoryDetails(){
        for(Book book : inventory.keySet()){
            book.printBookDetails();
            System.out.println("Quantity: "  + inventory.get(book));
        }
    }
}
