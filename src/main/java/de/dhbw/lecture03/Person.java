package de.dhbw.lecture03;

/**
 * Einfache Repräsentation einer Person
 * Ihre IDE sollte hier melden, dass es auch ein Record sein kann.
 * Zu dem Zeitpunkt "kennen" wir noch keine Records, weshalb wir darauf verzichten.
 * @param id  Durch die Initialiserung im Konstruktor kännen die Variablen final sein, sie werden garantiert nur einmal gefüllt
 */
public record Person(String id, String name, int age) {

}
