package de.dhbw.lecture09.task03;

public class User {
    private final int id;
    private final String displayName;

    public User(int id, String displayName) {
        this.id = id;
        this.displayName = displayName;
    }

    public int getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }
}
