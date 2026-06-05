package de.dhbw.lecture05.task02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class FootballPlayerFileHandlerTest {

    @Test
    void readFiles() {
        List<FootballPlayer> player = FootballPlayerFileHandler.readFiles();

        player.forEach(System.out::println);

        Assertions.assertEquals(23, player.size());
    }
}