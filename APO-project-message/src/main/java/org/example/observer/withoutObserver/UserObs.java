package org.example.observer.withoutObserver;


import java.util.ArrayList;
import java.util.List;

public class UserObs {
    private String username;
    private List<Message<UserObs>> messages;

    public UserObs(String username) {
        this.username = username;
        this.messages = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void sendMessage(UserObs recipient, String content) {
        Message<UserObs> message = new Message<>(this, content);
        recipient.receiveMessage(message);
    }

    public void receiveMessage(Message<UserObs> message) {
        System.out.println("Message received from " + message.getSender().getUsername() + ": " + message.getContent());
        message.markAsRead();
        notifySender(message.getSender());
    }

    private void notifySender(UserObs sender) {
        System.out.println("Notification to " + sender.getUsername() + ": Your message has been read.");
    }
}
