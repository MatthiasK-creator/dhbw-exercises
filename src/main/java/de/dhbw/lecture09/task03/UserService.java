package de.dhbw.lecture09.task03;

public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public String getDisplayName(int id) {
        User user = repository.findById(id);

        if (user == null) {
            return "Unbekannt";
        }

        return user.getDisplayName();
    }
}