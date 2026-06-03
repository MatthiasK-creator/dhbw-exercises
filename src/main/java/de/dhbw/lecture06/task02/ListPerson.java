package de.dhbw.lecture06.task02;

import java.util.Comparator;
import java.util.List;

public class ListPerson {
    static void main() {
        List<PersonRecord> personRecordList = List.of(
                new PersonRecord("Manuel", 50, 130),
                new PersonRecord("Thomas", 100, 125),
                new PersonRecord("Michael", 45, 115),
                new PersonRecord("Oliver", 30, 50),
                new PersonRecord("Marco", 30, 50)
        );

        // Nur der erste Schlüssel wird "umgekehrt", weshalb das reversed so stimmt
        // Packt ihr das reversed() hinter dem "thenComparing", dann steht Oliver vor Marco, obwohl das nicht stimmt
        Comparator<PersonRecord> comparator = Comparator.comparingInt(PersonRecord::punkte).reversed().thenComparing(PersonRecord::name);
        personRecordList.stream().sorted(comparator).forEach(System.out::println);

        System.out.println("---------");

        // Nutzt Comparables' compareTo()
        personRecordList.stream().sorted().forEach(System.out::println);

        // Neue Liste, ohne bestehende zu ändern
        List<PersonRecord> personRecordListSortiert = personRecordList.stream().sorted(comparator).toList();

        System.out.println("---nicht sortiert----");
        personRecordList.forEach(System.out::println);
        System.out.println("----sortiert----");
        personRecordListSortiert.forEach(System.out::println);

    }
}
