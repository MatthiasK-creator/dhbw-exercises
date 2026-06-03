package de.dhbw.lecture06.lottery_task;

import java.util.LinkedHashSet;
import java.util.Random;

public class LotteryVariantB {
    private static final Random random;

    // Denkt dran, ihr könnt auch mehrere statische Variablen in einem static-Block initialisieren
    // Hier natürlich eher sinnlos, da wir nur eines initialisren und nur als Showcase da.
    static {
        random = new Random();
    }

    public LinkedHashSet<Integer> drawNumber(){
        LinkedHashSet<Integer> numbers = new LinkedHashSet<>();
        while (numbers.size() < 7){
            // Annahme: "Superzahl" ist auch in der Spanne von 1-49, in der Realität ist sie in der Spanne 0-9
            numbers.add(random.nextInt(49) + 1);
        }
        return numbers;
    }
}
