package org.example.adapter.withoutAdapter;

public class SMSSender implements Mesaj {
    @Override
    public void trimiteMesaj(String destinatar, String continut) {
        System.out.println("Trimitere SMS catre " + destinatar + ": " + continut);
    }
}
