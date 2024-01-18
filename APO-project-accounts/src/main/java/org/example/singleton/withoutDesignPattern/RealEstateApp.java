package org.example.singleton.withoutDesignPattern;

public class RealEstateApp {
    private User realtor;
    private User client;

    public void createRealtorAccount(String name) {
        if (realtor == null) {
            realtor = new User(name);
            System.out.println("Realtor account created for " + name);
        } else {
            System.out.println("Realtor account already exists.");
        }
    }

    public void createClientAccount(String name) {
        if (client == null) {
            client = new User(name);
            System.out.println("Client account created for " + name);
        } else {
            System.out.println("Client account already exists.");
        }
    }

    public User getRealtor() {
        return realtor;
    }

    public User getClient() {
        return client;
    }
}
