package org.example.singleton;

public class CustomerAccount implements UserAccount {
    private String username;
    private String password;

    public CustomerAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
