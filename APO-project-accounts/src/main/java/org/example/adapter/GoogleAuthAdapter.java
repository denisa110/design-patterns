package org.example.adapter;

public class GoogleAuthAdapter implements AuthProvider {
    private GoogleAuthenticator googleAuthenticator;

    public GoogleAuthAdapter(GoogleAuthenticator googleAuthenticator) {
        this.googleAuthenticator = googleAuthenticator;
    }

    @Override
    public void authenticate() {
        googleAuthenticator.googleAuthenticate();
    }
}
