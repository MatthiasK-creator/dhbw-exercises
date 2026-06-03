package de.dhbw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class StreamTaskTest {

    @Test
    void readFiles() {
        List<FootballPlayer> player = StreamTask.readFiles();

        StreamTask.writeFile(player);

        player.forEach(System.out::println);

        Assertions.assertEquals(23, player.size());
    }
}