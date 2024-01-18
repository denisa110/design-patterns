package org.example.factory;

public class EmailMessageImpl implements IMessage {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending " + message + " from EmailNotification");
    }
}
