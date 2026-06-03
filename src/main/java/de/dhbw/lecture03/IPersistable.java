package de.dhbw.lecture03;


import java.util.List;

public interface IPersistable {
    void persist(Person person);
    Person load(String id);
    List<Person> loadAll();
}
