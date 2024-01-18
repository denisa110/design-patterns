package org.example.adapter;

public class EmailMessageSenderImpl implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending the e-mail: " + message);
    }
}
