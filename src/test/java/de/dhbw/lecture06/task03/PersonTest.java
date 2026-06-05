package de.dhbw.lecture06.task03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

class PersonTest {

    @Test
    void testPersonCollection() {
        // BONUS: Bei TreeSet wird beim Einfügen die Reihenfolge automatisch eingehalten, das passiert über Comprable, ist es nicht implementiert, dann wird
        // nach Defaults sortiert, was meistens nicht das richtige ist.
        Set<Person> personSet = new HashSet<>();

        personSet.add(new Person("Matthias", LocalDate.of(1990, 1, 1)));
        personSet.add(new Person("Matthias", LocalDate.of(1990, 1, 1)));


        Assertions.assertEquals(1, personSet.size());

        // Ohne korrekte Implementierung von equals() und hashCode() TRUE!!
        // Assertions.assertEquals(2, personSet.size());
        // Die Standardimplementierung von equals() stammt von Object und vergleicht die Referenzen
        // Da p1 und p2 zwei verschiedene Objekte im Speicher sind, gelten sie als unterschiedlich.
    }

    @Test
    void testPersonSorting() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Malea", LocalDate.of(2024, 1, 2)));
        personList.add(new Person("Matthias", LocalDate.of(1990, 1, 1)));

        // Funktioniert automatisch, da Comparable korrekt implementiert ist
        Collections.sort(personList);

        Assertions.assertEquals(2, personList.size());
        Assertions.assertEquals("Matthias", personList.getFirst().name());

        // Explizite Sortierung, Verkettung möglich
        personList.sort(Comparator.comparing(Person::name));
        Assertions.assertEquals("Malea", personList.getFirst().name());

    }

}