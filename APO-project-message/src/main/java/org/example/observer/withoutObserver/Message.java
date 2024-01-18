package org.example.observer.withoutObserver;

public class Message<U> {
    private String content;
    private boolean readStatus;
    private UserObs sender;

    public Message(UserObs sender, String content) {
        this.sender = sender;
        this.content = content;
        this.readStatus = false;
    }

    public void markAsRead() {
        this.readStatus = true;
    }

    public UserObs getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    public boolean isRead() {
        return readStatus;
    }
}
