package org.example.adapter;

public class SMSMessageSenderImpl implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending the message SMS: " + message);
    }
}
