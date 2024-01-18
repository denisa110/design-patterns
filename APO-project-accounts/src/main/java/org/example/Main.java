package org.example;
import org.example.adapter.*;
import org.example.observer.AgentSubjectImpl;
import org.example.observer.ClientObserverImpl;
import org.example.observer.Observer;
import org.example.observer.withoutDesignPattern.RealEstateAgent;
import org.example.observer.withoutDesignPattern.RealEstateObserver;
import org.example.singleton.CustomerAccount;
import org.example.singleton.SellerAccount;
import org.example.singleton.UserAccount;
import org.example.singleton.UserAccountManager;
import org.example.singleton.withoutDesignPattern.RealEstateApp;
import org.example.singleton.withoutDesignPattern.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //FARA SINGLETON
        System.out.println("----- FARA SINGLETON:");
        RealEstateApp realEstateApp = new RealEstateApp();

        realEstateApp.createRealtorAccount("Realtor1");
        realEstateApp.createRealtorAccount("Realtor2");

        realEstateApp.createClientAccount("Client1");
        realEstateApp.createClientAccount("Client2");

        User realtor = realEstateApp.getRealtor();
        if (realtor != null) {
            System.out.println("Current user: " + realtor.getName());
        }

        User client = realEstateApp.getClient();
        if (client != null) {
            System.out.println("Current user: " + client.getName());
        }

        // SINGLETON
        System.out.println("----- SINGLETON:");
        UserAccount customerAccount = new CustomerAccount("customer1", "password1");
        UserAccount sellerAccount = new SellerAccount("seller1", "password2");

        UserAccountManager userAccountManager = UserAccountManager.getInstance();

        userAccountManager.addUserAccount(customerAccount);
        userAccountManager.addUserAccount(sellerAccount);

        System.out.println(customerAccount.getUsername());
        System.out.println(customerAccount.getPassword());


        // ADAPTOR
        System.out.println("----- FARA ADAPTER, IMPLEMENTARE: ");
        String authTypeUserPass = "userPass";
        if ("userPass".equals(authTypeUserPass)) {
            UserPassAuthenticator userPassAuthenticator = new UserPassAuthenticator();
            userPassAuthenticator.userPassAuthenticate();
        } else if ("google".equals(authTypeUserPass)) {
            // Utilizare pentru autentificare cu Google
            GoogleAuthenticator googleAuthenticator = new GoogleAuthenticator();
            googleAuthenticator.googleAuthenticate();
        } else {
            System.out.println("Metoda de autentificare necunoscută.");
        }

        // Utilizare pentru autentificare cu Google
        String authTypeGoogle = "google";
        if ("userPass".equals(authTypeGoogle)) {
            UserPassAuthenticator userPassAuthenticator = new UserPassAuthenticator();
            userPassAuthenticator.userPassAuthenticate();
        } else if ("google".equals(authTypeGoogle)) {
            GoogleAuthenticator googleAuthenticator = new GoogleAuthenticator();
            googleAuthenticator.googleAuthenticate();
        } else {
            System.out.println("Metoda de autentificare necunoscută.");
        }

        System.out.println("----- ADAPTER:");
        // Utilizarea Adaptorului pentru a face GoogleAuthenticator compatibil cu AuthProvider
        GoogleAuthenticator googleAuthenticator = new GoogleAuthenticator();
        AuthProvider googleAuthProvider = new GoogleAuthAdapter(googleAuthenticator);

        // Apelarea metodei authenticate pe AuthProvider
        googleAuthProvider.authenticate();

        // Utilizarea Adaptorului pentru a face UserPassAuthenticator compatibil cu AuthProvider
        UserPassAuthenticator userPassAuthenticator = new UserPassAuthenticator();
        AuthProvider userPassAuthProvider = new UserPassAuthAdapter(userPassAuthenticator);

        // Apelarea metodei authenticate pe AuthProvider
        userPassAuthProvider.authenticate();

        //OBSERVER
        System.out.println("----- FARA OBSERVER:");
        RealEstateObserver app = new RealEstateObserver();


        RealEstateAgent agent1 = new RealEstateAgent("John Doe");
        RealEstateAgent agent2 = new RealEstateAgent("Jane Smith");

        app.addAgent(agent1);
        app.addAgent(agent2);

        app.connectAgent(agent1);
        app.displayConnectedAgents();

        System.out.println("----- OBSERVER:");

        AgentSubjectImpl agent = new AgentSubjectImpl("Ionescu Maria");

        ClientObserverImpl client1 = new ClientObserverImpl("Popescu Ion", agent);
        ClientObserverImpl client2 = new ClientObserverImpl("Vasilescu Ana", agent);

        List<Observer> clientToAdd = new ArrayList<>();
        clientToAdd.add(client1);
        clientToAdd.add(client2);

        agent.connect(clientToAdd);
    }
}