package org.example.observer;

import java.util.List;

public interface Subject {
    void addObserver(Observer observer);

    void addObservers(List<Observer> observers);

    void deleteObserver(Observer observer);

    void sendNotification(String message);
}
