package de.dhbw.lecture08;

import java.util.concurrent.CompletableFuture;

public class RestController {
    private final BelegSpeichernService belegSpeichernService;

    public RestController(BelegSpeichernService belegSpeichernService) {
        this.belegSpeichernService = belegSpeichernService;
    }

    // POSt-MAPPING localhost:8080/beleg/
    public void saveRoute() {
        CompletableFuture.runAsync(belegSpeichernService::save);
    }
}
