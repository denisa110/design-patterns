package org.example.adapter;

public class MessageSenderAdapter implements MessageSender {
    private EmailMessageSenderImpl emailMessageSender;

    public MessageSenderAdapter(EmailMessageSenderImpl emailMessageSender) {
        this.emailMessageSender = emailMessageSender;
    }

    @Override
    public void sendMessage(String message) {
        emailMessageSender.sendMessage(message);
    }
}
