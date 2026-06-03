package de.dhbw.lecture04;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

    // Bonus: Exception in Datei protokollieren
    // Datei error.log finden Sie unterhalb des Root-Verzeichnisses des Projekts.
    public static void logException(Exception e) {
        try (PrintWriter writer =
                     new PrintWriter(new FileWriter("error.log", true))) {

            writer.println("Fehler: " + e.getMessage());
            writer.println("----------------------------");

        } catch (IOException ioException) {
            System.out.println("Fehler beim Schreiben der Log-Datei.");
        }
    }

    static void main(String[] args) {

        BankAccount konto = new BankAccount(1000.0, 200.0);

        try {
            konto.deposit(500);
            System.out.println("Einzahlung erfolgreich.");
            System.out.println("Kontostand: " + konto.getBalance() + " €");

        } catch (InvalidAmountException e) {
            System.out.println("Fehler: " + e.getMessage());
            logException(e);
        }

        try {
            konto.withdraw(1200);
            System.out.println("Abhebung erfolgreich.");
            System.out.println("Kontostand: " + konto.getBalance() + " €");

        } catch (InvalidAmountException | InsufficientFundsException e) {
            System.out.println("Fehler: " + e.getMessage());
            logException(e);
        }

        try {
            konto.withdraw(100);
            System.out.println("Abhebung erfolgreich.");
            System.out.println("Kontostand: " + konto.getBalance() + " €");

        } catch (InvalidAmountException | InsufficientFundsException e) {
            System.out.println("Fehler: " + e.getMessage());
            logException(e);
        }

        // InsufficientFundsException
        try {
            konto.withdraw(1000);
            System.out.println("Abhebung erfolgreich????");
            System.out.println("Kontostand: " + konto.getBalance() + " €");

        } catch (InvalidAmountException | InsufficientFundsException e) {
            System.out.println("Fehler: " + e.getMessage());
            System.out.println("Kontostand: " + konto.getBalance() + " €");
            logException(e);
        }

        // Ungültiger Betrag
        try {
            konto.deposit(-50);

        } catch (InvalidAmountException e) {
            System.out.println("Fehler: " + e.getMessage());
            logException(e);
        }

        // Randfall: exakten Restbetrag abheben
        try {
            konto.withdraw(konto.getBalance());
            System.out.println("Restbetrag vollständig abgehoben.");
            System.out.println("Kontostand: " + konto.getBalance() + " €");

        } catch (InvalidAmountException | InsufficientFundsException e) {
            System.out.println("Fehler: " + e.getMessage());
            logException(e);
        }
    }
}