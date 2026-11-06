package de.dhbw.lecture09.live_coding;

import java.time.LocalDateTime;

public class Beleg {
    private LocalDateTime eingangsdatum;

    public LocalDateTime getEingangsdatum() {
        return eingangsdatum;
    }

    public void setEingangsdatum(LocalDateTime eingangsdatum) {
        this.eingangsdatum = eingangsdatum;
    }
}
