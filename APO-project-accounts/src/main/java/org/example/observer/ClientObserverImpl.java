package org.example.observer;

public class ClientObserverImpl implements Observer {
    private String name;
    private AgentSubjectImpl agent;

    public ClientObserverImpl(String name, AgentSubjectImpl agent) {
        this.name = name;
        this.agent = agent;
        agent.registerObserver(this);
    }

    @Override
    public void update(String message) {
        System.out.println(message);
    }
}
