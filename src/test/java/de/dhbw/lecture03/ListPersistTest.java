package de.dhbw.lecture03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Dieser Test ist in der Aufgabenstellung nicht gefordert.
 * Es ist auch in Ordnung, wenn über eine Main-Methode geprüft wird, ob die Implementierung funktioniert.
 */
class ListPersistTest {

    @Test
    void givenPerson_whenSave_thenSaved() {
        Person p = new Person("blub", "Max", 23);
        ListPersist arrayPersist = new ListPersist();

        arrayPersist.persist(p);

        assertFalse(arrayPersist.loadAll().isEmpty());
        Assertions.assertEquals(p, arrayPersist.loadAll().getFirst());
    }

    @Test
    void givenPersistedPerson_whenLoad_thenLoadPerson() {
        Person person = new Person("blub", "Max", 23);
        ListPersist arrayPersist = new ListPersist();

        arrayPersist.persist(person);
        Person personToBeAsserted = arrayPersist.load(person.id());

        Assertions.assertEquals(person, personToBeAsserted);
    }
}