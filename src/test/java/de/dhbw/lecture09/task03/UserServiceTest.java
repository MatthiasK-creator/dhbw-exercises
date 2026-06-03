package de.dhbw.lecture09.task03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Test
    @DisplayName("DisplayName wird für vorhandenen Benutzer geliefert")
    void getDisplayName_userExistiert_displayNameWirdGeliefert() {
        // Arrange
        UserRepository repo = mock(UserRepository.class);
        UserService service = new UserService(repo);

        User user = new User(1, "Max Mustermann");

        when(repo.findById(1)).thenReturn(user);

        // Act
        String result = service.getDisplayName(1);

        // Assert
        assertEquals("Max Mustermann", result);
        verify(repo).findById(1);
    }

    @Test
    @DisplayName("Unbekannt wird geliefert, wenn Benutzer nicht existiert")
    void getDisplayName_userNichtVorhanden_unbekanntWirdGeliefert() {
        // Arrange
        UserRepository repo = mock(UserRepository.class);
        UserService service = new UserService(repo);

        when(repo.findById(99)).thenReturn(null);

        // Act
        String result = service.getDisplayName(99);

        // Assert
        assertEquals("Unbekannt", result);
        verify(repo).findById(99);
    }

    @Test
    @DisplayName("Repository-Fehler wird weitergereicht")
    void getDisplayName_repositoryWirftFehler_exceptionWirdGeworfen() {
        // Arrange
        UserRepository repo = mock(UserRepository.class);
        UserService service = new UserService(repo);

        when(repo.findById(5))
                .thenThrow(new RuntimeException("DB nicht erreichbar"));

        // Act + Assert
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> service.getDisplayName(5)
        );

        assertEquals("DB nicht erreichbar", exception.getMessage());
        verify(repo).findById(5);
    }
}