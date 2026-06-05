package de.dhbw.lecture03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Dieser Test ist in der Aufgabenstellung nicht gefordert.
 * Es ist auch in Ordnung, wenn über eine Main-Methode geprüft wird, ob die Implementierung funktioniert.
 */
class ArrayPersistTest {

    @Test
    void givenPerson_whenSave_thenSaved() {
        Person p = new Person("blub", "Max", 23);
        ArrayPersist arrayPersist = new ArrayPersist();

        arrayPersist.persist(p);

        Assertions.assertTrue(arrayPersist.getPersonArray().length > 0);
        Assertions.assertEquals(p, arrayPersist.getPersonArray()[0]);
    }

    @Test
    void givenPersistedPerson_whenLoad_thenLoadPerson() {
        Person person = new Person("blub", "Max", 23);
        ArrayPersist arrayPersist = new ArrayPersist();

        arrayPersist.persist(person);
        Person personToBeAsserted = arrayPersist.load(person.id());

        Assertions.assertEquals(person, personToBeAsserted);
    }
}