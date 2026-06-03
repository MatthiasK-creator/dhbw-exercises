package de.dhbw;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class StreamTask {
    public static List<FootballPlayer> readFiles() {

        try {
            return Files.readAllLines(Paths.get("/Users/mklee/Desktop/vorlesung/tasks/04_dfb_team.csv"))
                    .stream().map(line -> line.split(";"))
                    .map(split -> new FootballPlayer(Integer.parseInt(split[0]), split[1], split[2], split[3], split[4], Integer.parseInt(split[5]),
                            Integer.parseInt(split[6]))).toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void writeFile(List<FootballPlayer> list){
        try (var writer = Files.newBufferedWriter(Paths.get("/tmp/blub.csv"))){
            writer.write(list.stream().reduce("", (acc, player) -> acc + player.toString() + ", ", (a, b) -> a + b));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
