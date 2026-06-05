package de.dhbw.lecture08.live_coding_snippets;

import java.util.concurrent.CompletableFuture;

/**
 * Live-Coding-Snippet, um CompletableFuture<Void> zu verdeutlichen
 * Kernausage: Der Caller der MEthode sollte verantwortlich sein, die Logik asynchron aufzurufen
 * Zweite Kernaussage: Erst optimieren, wenn Bedarf besteht. Asynchronität kann bei sauberer Implementierung leicht hinzugefügt werden.
 */
public class BelegSpeichernService {

    public CompletableFuture<Void> saveAsync() {
        return CompletableFuture.runAsync(this::save);
    }

    public void save() {
        // hat ganz viel Business Logic
    }
}
