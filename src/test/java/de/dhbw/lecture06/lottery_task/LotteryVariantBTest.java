package de.dhbw.lecture06.lottery_task;

import org.junit.jupiter.api.RepeatedTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LotteryVariantBTest {

    // Hier mal die Variante mit RepeatedTest
    @RepeatedTest(1000)
    void drawNumber() {
        LotteryVariantB lottery = new LotteryVariantB();
        Set<Integer> draw = lottery.drawNumber();

        assertEquals(7, draw.size());
        assertTrue(noDuplications(draw));
        assertTrue(draw.stream().allMatch(i -> i >= 1 && i <= 49));
    }

    private boolean noDuplications(Set<Integer> draw) {
        return draw.size() == draw.stream().distinct().count();
    }
}