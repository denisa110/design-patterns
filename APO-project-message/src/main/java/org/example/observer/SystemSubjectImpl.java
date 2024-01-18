package org.example.observer;

import java.util.List;

public class SystemSubjectImpl implements Subject {
    private String numeSistem;
    private List<Observer> observers;
    public SystemSubjectImpl(String numeSistem, List<Observer> observers) {
        this.numeSistem = numeSistem;
        this.observers = observers;
    }
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void addObservers(List<Observer> lstObservers) {
        observers.addAll(lstObservers);
    }

    @Override
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }
    @Override
    public void sendNotification(String message) {
        for (Observer observer : observers) {
            observer.receivingMessage(message);
        }
    }
}
