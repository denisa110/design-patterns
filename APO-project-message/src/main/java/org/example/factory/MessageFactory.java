package org.example.factory;

import java.util.Locale;

import static java.util.Objects.isNull;

public class MessageFactory {
    public static final String SMS = "SMS";
    public static final String EMAIL = "EMAIL";


    public IMessage createNotification(String type) {
        if (isNull(type) || type.isEmpty()) {
            return null;
        } else {
            return switch (type.toUpperCase(Locale.ROOT)) {
                case SMS -> new SMSMessageImpl();
                case EMAIL -> new EmailMessageImpl();
                default -> throw new IllegalArgumentException("Unknown Notification Type received");
            };
        }
    }
}
