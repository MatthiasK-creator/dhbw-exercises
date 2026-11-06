package de.dhbw.lecture09.live_coding;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

class BelegVerarbeitungTest {

    @Test
    void verarbeiten() {
        Beleg beleg = new Beleg();
        Instant instant = LocalDateTime.of(2025, 12, 24, 9, 30, 10).toInstant(ZoneOffset.UTC);
        Clock clock = Clock.fixed(instant, ZoneOffset.UTC);
        BelegVerarbeitung belegVerarbeitung = new BelegVerarbeitung(clock);
        belegVerarbeitung.verarbeiten(beleg);
        Assertions.assertEquals(LocalDateTime.ofInstant(instant, ZoneOffset.UTC), beleg.getEingangsdatum());
    }
}