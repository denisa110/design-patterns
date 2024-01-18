package org.example.singleton;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;

public class UserAccountManager {
    private static UserAccountManager instance;
    private Map<String, UserAccount> userAccounts;
    private UserAccountManager() {
    };
    public static UserAccountManager getInstance() {
        if (isNull(instance)) {
            instance = new UserAccountManager();
        }
        return instance;
    }
    public void addUserAccount(UserAccount user) {
        if (isNull(userAccounts)) {
            userAccounts = new HashMap<>();
        }
        synchronized (userAccounts) {
            userAccounts.put(user.getUsername(), user);
            userAccounts.put(user.getPassword(), user);
        }
    }
    public String getUserAccount(String username) {
        return username;
    }
}
