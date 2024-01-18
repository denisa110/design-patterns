package org.example.observer;

import java.util.ArrayList;
import java.util.List;

public class AgentSubjectImpl implements Subject {
    private String name;
    private List<Observer> observers;
    public AgentSubjectImpl(String name) {
        this.observers = new ArrayList<>();
        this.name = name;
    }
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
    @Override
    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(String.format("Agentul dumneavoastra %s s-a conectat pe aplicatie", name));
        }
    }
    public void connect(List<Observer> clientToAdd) {
        notifyObservers();
    }
}
