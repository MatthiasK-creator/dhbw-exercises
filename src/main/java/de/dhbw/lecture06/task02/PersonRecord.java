package de.dhbw.lecture06.task02;

public record PersonRecord(String name, int punkte, int spiele) implements Comparable<PersonRecord> {
    @Override
    public int compareTo(PersonRecord o) {
        // Hinweis: Das sieht sehr klug aus, macht aber in der Implementierung nichts anderes als:
        // return (x < y) ? -1 : ((x == y) ? 0 : 1);
        return Integer.compare(o.punkte(), punkte());
    }
}
