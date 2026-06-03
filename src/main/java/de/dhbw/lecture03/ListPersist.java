package de.dhbw.lecture03;

import java.util.ArrayList;
import java.util.List;

public class ListPersist implements IPersistable {
    private final List<Person> personList;

    public ListPersist() {
        this.personList = new ArrayList<>();
    }

    @Override
    public void persist(Person person) {
        personList.add(person);
    }

    @Override
    public Person load(String id) {
        for (Person person : personList) {
            if (person.getId().equals(id)) {
                return person;
            }
        }
        throw new RuntimeException("No such person");
    }

    @Override
    public List<Person> loadAll() {
        return personList;
    }
}
