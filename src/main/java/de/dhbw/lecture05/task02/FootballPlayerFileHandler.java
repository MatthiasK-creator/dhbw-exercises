package de.dhbw.lecture05.task02;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

/**
 * Diese Aufgabe hatten wir in der Vorlesung nie behandelt.
 * Weil es dennoch eine gute Orientierung für die Streaming-API ist, lasse ich sie hier drin.
 * Aufgabenstellung wäre gewesen:
 *  - Schreiben Sie ein Klasse FootballPlayer(oder Record), welches einen Fußballspieler repräsentiert:
 *      - Integer id
 *      - String name
 *      - String position
 *      - String birthDate
 *      - String club
 *      - Integer playedGames
 *      - Integer goals
 *  - Schreiben Sie eine KlasseFootballPlayerFileHandler, welches die Datei '05_dfb_team.csv' im Resource-Verzeichnis einliest und in FootballPlayer-Objekte umwandelt.
 *  => Resultat soll eine Liste von FootballPlayer-Objekten sein.
 */
public class FootballPlayerFileHandler {
    public static List<FootballPlayer> readFiles() {
        try {
            return Files.readAllLines(Path.of(Objects.requireNonNull(FootballPlayerFileHandler.class.getClassLoader().getResource("05_dfb_team.csv")).toURI()))
                    .stream().map(line -> line.split(";"))
                    .map(split -> new FootballPlayer(Integer.parseInt(split[0]),
                            split[1],
                            split[2],
                            split[3],
                            split[4],
                            Integer.parseInt(split[5]),
                            Integer.parseInt(split[6]))).toList();
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }

    }
}
