package de.dhbw.lecture08.task02;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class FetchUrls {
    public void fetchUrlsWithFuture() {
        Runnable runnable = () -> {

            try (HttpClient client = HttpClient.newHttpClient()) {
                HttpResponse<String> response = client.send(HttpRequest.newBuilder().GET().uri(URI.create("https://catfact.ninja/fact")).build(),
                        HttpResponse.BodyHandlers.ofString());
                String s = response.body();
                System.out.println("Fact: " + s);
                System.out.println("Status: " + s.length());
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        try (ExecutorService executorService = Executors.newFixedThreadPool(5)) {
            IntStream.range(0, 10).forEach(i -> {
                Future<?> future = executorService.submit(runnable);
                try {
                    future.get();
                } catch (InterruptedException | ExecutionException e) {
                    // Bei Fehler innerhalb der URL landet man hier und kann es entsprechend behandeln
                    throw new RuntimeException(e);
                }
            });
        } catch (Exception _) {
        }
    }

    public void fetchUrlsWithCompletableFuture() {
        Supplier<String> runnable = () -> {

            try (HttpClient client = HttpClient.newHttpClient()) {
                HttpResponse<String> response = client.send(HttpRequest.newBuilder().GET().uri(URI.create("https://catfact.ninja/fact")).build(),
                        HttpResponse.BodyHandlers.ofString());
                String s = response.body();
                System.out.println("Fact: " + s);
                System.out.println("Status: " + s.length());
                return response.body();
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            List<CompletableFuture<String>> completableFutures = new ArrayList<>();
            IntStream.range(0, 10).forEach(i -> {
                completableFutures.add(CompletableFuture.supplyAsync(runnable, executorService)
                        // Bei CompletionException landet man hier und kann es entsprechend behandeln
                        .exceptionally(s -> {
                            System.out.println("Fehler: " + s);
                            throw new RuntimeException(s);
                        }));
            });

            CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0])).join();
        }
    }

    static void main() throws InterruptedException {
        FetchUrls fetchUrls = new FetchUrls();
        System.out.println("Erster Lauf mit Futures...");
        fetchUrls.fetchUrlsWithFuture();
        System.out.println("---Kurze Pause 1s---");
        Thread.sleep(1000);
        System.out.println("Zweiter Lauf mit CompleteableFutures...");
        fetchUrls.fetchUrlsWithCompletableFuture();
    }

}
