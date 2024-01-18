package org.example.factory.withoutDesignPattern;

public class FSMS {


    private String content;

    public FSMS(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
    public void send() {
        System.out.println("SMS sent: " + content);
    }
}
