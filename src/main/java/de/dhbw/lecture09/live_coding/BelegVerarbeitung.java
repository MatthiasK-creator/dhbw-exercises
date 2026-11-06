package de.dhbw.lecture09.live_coding;

import java.time.Clock;
import java.time.LocalDateTime;

public class BelegVerarbeitung {
    private Clock clock;

    public BelegVerarbeitung(Clock clock) {
        this.clock = clock;
    }

    public void verarbeiten(Beleg beleg) {
        beleg.setEingangsdatum(LocalDateTime.ofInstant(clock.instant(), clock.getZone()));
    }
}
