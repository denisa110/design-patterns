package org.example.observer;

public class User implements Observer {
    private int id;
    private String name;
    private String lastName;
    private String email;
    private String numeUtilizator;

    public User(int id, String name, String lastName, String email, String numeUtilizator) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.numeUtilizator = numeUtilizator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeUtilizator() {
        return numeUtilizator;
    }

    public void setNumeUtilizator(String numeUtilizator) {
        this.numeUtilizator = numeUtilizator;
    }

    @Override
    public void receivingMessage(String message) {
        System.out.println("The user with the name: " + name + " received the message: " + message);
    }
}
