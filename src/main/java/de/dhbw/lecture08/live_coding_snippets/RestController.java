package de.dhbw.lecture08.live_coding_snippets;

import java.util.concurrent.CompletableFuture;

public class RestController {
    private final BelegSpeichernService belegSpeichernService;

    public RestController(BelegSpeichernService belegSpeichernService) {
        this.belegSpeichernService = belegSpeichernService;
    }

    // Post-MAPPING localhost:8080/beleg/
    // Caller ruft belegspeichern asynchron auf
    public void saveRoute() {
        CompletableFuture.runAsync(belegSpeichernService::save);
    }
}
