package de.dhbw.lecture03;

import java.util.Arrays;
import java.util.List;

public class ArrayPersist implements IPersistable {
    private static final int DEFAULT_LENGTH = 100;
    private final Person[] personArray;

    public ArrayPersist() {
        // Keine 'magic variables' lieber eine Konstante, die beschreibt, was man tut.
        this.personArray = new Person[DEFAULT_LENGTH];
    }

    @Override
    public void persist(Person person) {
        for (int i = 0; i < personArray.length; i++) {
            Person tmpPerson = personArray[i];
            if (tmpPerson == null) {
                personArray[i] = person;
                return;
            }
        }

        // Nicht gefordert, aber sinnvoll
        throw new RuntimeException("Array is full");
    }

    @Override
    public Person load(String id) {
        for (int i = 0; i < personArray.length; i++) {
            Person tmpPerson = personArray[i];
            if (tmpPerson != null && tmpPerson.getId().equals(id)) {
                return tmpPerson;
            }
        }

        // Nicht gefordert, aber sinnvoll
        throw new RuntimeException("No such person");
    }

    @Override
    public List<Person> loadAll() {
        return Arrays.stream(personArray).toList();
    }

    // Wird für die Tests verwendet, ist nicht gefordert.
    public Person[] getPersonArray() {
        return personArray;
    }
}
