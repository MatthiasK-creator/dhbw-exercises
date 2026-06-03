package de.dhbw.lecture08;

import java.util.concurrent.CompletableFuture;

public class BelegSpeichernService {

    public CompletableFuture<Void> saveAsync() {
        return CompletableFuture.runAsync(this::save);
    }

    public void save() {
        // hat ganz viel Business Logic
    }
}
