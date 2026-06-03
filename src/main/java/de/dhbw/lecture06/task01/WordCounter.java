package de.dhbw.lecture06.task01;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;


public class WordCounter {
    public void countWords(Path path) {
        try {

            // Bisschen fiess, aber die Verwendung der LinkedHashMap sorgt dafür, dass die Reihenfolge des ersten Auftretens gespeichert wird. Da Stream
            // .sorted() stabil ist, bleiben bei gleicher Häufigkeit die Wörter in dieser ursprünglichen Einfügereihenfolge erhalten.
            Map<String, Integer> frequencies = new LinkedHashMap<>();

            Files.readAllLines(path).stream()
                    .flatMap(line -> java.util.Arrays.stream(line.split("\\s+")))
                    .map(String::toLowerCase) // case-insensitive
                    .filter(word -> !word.isBlank())
                    .forEach(word -> frequencies.merge(word, 1, Integer::sum));

            frequencies.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .limit(10)
                    .forEach(entry ->
                            System.out.println(entry.getKey() + " : " + entry.getValue()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void main() throws URISyntaxException {
        WordCounter counter = new WordCounter();
        // Datei unter src/main/resources/lorem.txt
        counter.countWords(Path.of(Objects.requireNonNull(WordCounter.class.getClassLoader().getResource("lorem.txt")).toURI()));
    }
}
