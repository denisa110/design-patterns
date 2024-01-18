package org.example.factory.withoutDesignPattern;

public class FEmail {
    private String content;

    public FEmail(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
    public void send() {
        System.out.println("Email sent: " + content);
    }
}
