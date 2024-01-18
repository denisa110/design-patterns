package org.example.observer.withoutDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class RealEstateObserver {
    private List<RealEstateAgent> agents;

    public RealEstateObserver() {
        this.agents = new ArrayList<>();
    }

    public void addAgent(RealEstateAgent agent) {
        agents.add(agent);
    }

    public void connectAgent(RealEstateAgent agent) {
        agent.connect();
    }

    public void disconnectAgent(RealEstateAgent agent) {
        agent.disconnect();
    }

    public void displayConnectedAgents() {
        List connectedAgents = new ArrayList<>();
        for (RealEstateAgent agent : agents) {
            if (agent.isConnected()) {
                connectedAgents.add(agent.getName());
            }
        }
        System.out.println("Connected Agents: " + connectedAgents);
    }
}
