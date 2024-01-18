package org.example.adapter;

public class UserPassAuthAdapter implements AuthProvider {
    private UserPassAuthenticator userPassAuthenticator;

    public UserPassAuthAdapter(UserPassAuthenticator userPassAuthenticator) {
        this.userPassAuthenticator = userPassAuthenticator;
    }

    @Override
    public void authenticate() {
        userPassAuthenticator.userPassAuthenticate();
    }
}
