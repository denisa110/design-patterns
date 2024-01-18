package org.example.observer.withoutDesignPattern;

public class RealEstateAgent {
    private String name;
    private boolean isConnected;

    public RealEstateAgent(String name) {
        this.name = name;
        this.isConnected = false;
    }

    public String getName() {
        return name;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public void connect() {
        isConnected = true;
    }

    public void disconnect() {
        isConnected = false;
    }
}
