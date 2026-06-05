package de.dhbw.lecture06.task03;

import java.time.LocalDate;

/**
 * Lösungen für die Aufgaben befinden sich in den Tests
 */
public record Person(String name, LocalDate age) implements Comparable<Person> {

    @Override
    public int compareTo(Person o) {
        return this.age.compareTo(o.age);
    }
}
