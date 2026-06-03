package de.dhbw.lecture06.task03;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Lösungen für die Aufgaben befinden sich in den Tests
 */
public class Person implements Comparable<Person>{
    private final String name;
    private final LocalDate age;

    public Person(String name, LocalDate age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Person o) {
        return this.age.compareTo(o.age);
    }

    public String getName() {
        return name;
    }

    public LocalDate getAge() {
        return age;
    }
}
