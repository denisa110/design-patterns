package org.example;

import org.example.adapter.EmailMessageSenderImpl;
import org.example.adapter.MessageSenderAdapter;
import org.example.adapter.SMSMessageSenderImpl;
import org.example.adapter.withoutAdapter.EmailSender;
import org.example.adapter.withoutAdapter.Mesaj;
import org.example.adapter.withoutAdapter.SMSSender;
import org.example.factory.EmailMessageImpl;
import org.example.factory.IMessage;
import org.example.factory.MessageFactory;
import org.example.factory.SMSMessageImpl;
import org.example.factory.withoutDesignPattern.FEmail;
import org.example.factory.withoutDesignPattern.FSMS;
import org.example.observer.Observer;
import org.example.observer.SystemSubjectImpl;
import org.example.observer.User;
import org.example.observer.withoutObserver.Message;
import org.example.observer.withoutObserver.UserObs;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //WITHOUT FACTORY
        System.out.println("***WITHOUT FACTORY METHOD ***");
        FSMS fSmsMessage = new FSMS("SMS message content");
        FEmail fEmailMessage = new FEmail("Email message content");

        // Send the messages
        fSmsMessage.send();
        fEmailMessage.send();

        // Check the type and display content if it's an Email
        if (fEmailMessage instanceof FEmail) {
            System.out.println("Email content: " + ((FEmail) fEmailMessage).getContent());
        }

        // Check the type and display content if it's an SMS
        if (fSmsMessage instanceof FSMS) {
            System.out.println("SMS content: " + ((FSMS) fSmsMessage).getContent());
        }

        //FACTORY
        System.out.println("*** FACTORY METHOD ***");
        // Solutie pentru utilizarea design pattern-ului Factory
        try {
            MessageFactory notificationFactory = new MessageFactory();
            IMessage smsNotificationFactory = notificationFactory.createNotification("email");
            smsNotificationFactory.sendMessage("My new message about the X ad ");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        //OBSERVER
        System.out.println("***WITHOUT OBSERVER ***");
        UserObs user11 = new UserObs("Alice");
        UserObs user22 = new UserObs("Bob");

        user11.sendMessage(user22, "Hello, Bob!");
        Message<UserObs> messageFromAlice = new Message<>(user11, "Hello, Bob!");
        user22.receiveMessage(messageFromAlice);

        System.out.println("***WITH OBSERVER ***");
        User user1 = new User(1, "Lupancu", "Denisa", "denisalupancu@gmail.com", "denisa123");
        User user2 = new User(2, "Alecu", "Alma", "alecualma@gmail.com", "alma123");

        List<Observer> usersToAdd = new ArrayList<>();
        usersToAdd.add(user1);
        usersToAdd.add(user2);

        SystemSubjectImpl system = new SystemSubjectImpl("SiteImobiliare", new ArrayList<>());
        system.addObservers(usersToAdd);

        system.sendNotification("First message ");


        //WITHOUT ADAPTER
        System.out.println("***WITHOUT ADAPTER ***");
        Mesaj smsSender = new SMSSender();
        smsSender.trimiteMesaj("123456789", "Salut!");

        Mesaj emailSender = new EmailSender();
        emailSender.trimiteMesaj("exemplu@email.com", "Hello!");

        //ADAPTER
        System.out.println("***WITH ADAPTER ***");
        SMSMessageSenderImpl smsMessageSender = new SMSMessageSenderImpl();
        EmailMessageSenderImpl emailMessageSender = new EmailMessageSenderImpl();
        MessageSenderAdapter messageSenderAdapter = new MessageSenderAdapter(emailMessageSender);

        messageSenderAdapter.sendMessage("This is a message sent using the Adapter");
    }
}