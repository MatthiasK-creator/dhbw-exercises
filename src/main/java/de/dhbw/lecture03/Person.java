package de.dhbw.lecture03;

/**
 * Einfache Repräsentation einer Person
 * Zurecht weißt eure IDE euch daraufhin, dass es auch ein Record sein kann.
 * Zu dem Zeitpunkt "kennen" wir das noch nicht, weshalb wir darauf verzichten.
 */
public class Person {

    // Durch die Initialiserung im Konstruktor kännen die Variablen final sein, sie werden garantiert nur einmal gefüllt
    private final String id;
    private final String name;
    private final int age;

    public Person(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
