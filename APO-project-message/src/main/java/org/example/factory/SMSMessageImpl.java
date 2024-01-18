package org.example.factory;

public class SMSMessageImpl implements IMessage {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending " + message + " from SMSNotification");
    }
}
