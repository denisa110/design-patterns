package org.example.adapter.withoutAdapter;

public class EmailSender implements Mesaj {
    @Override
    public void trimiteMesaj(String destinatar, String continut) {
        System.out.println("Trimitere Email catre " + destinatar + ": " + continut);
    }
}
