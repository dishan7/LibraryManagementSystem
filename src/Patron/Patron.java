package Patron;

import Book.Book;

import java.util.ArrayList;

public class Patron {

    private int patronId;
    private String patronName;
    private String email;

    public Patron(int patronId, String patronName, String email) {
        this.patronId = patronId;
        this.patronName = patronName;
        this.email = email;
    }

    public int getPatronId() {
        return patronId;
    }

    public void setPartonId(int partonId) {
        this.patronId = partonId;
    }

    public String getPatronName() {
        return patronName;
    }

    public void setPatronName(String patronName) {
        this.patronName = patronName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void printPatronDetails(){
        System.out.println("Patron ID: " + patronId);
        System.out.println("Patron Name: " + patronName);
        System.out.println("Email: " + email);
        System.out.println("History: ");
    }
}
