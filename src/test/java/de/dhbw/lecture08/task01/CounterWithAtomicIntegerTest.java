package de.dhbw.lecture08.task01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

class CounterWithAtomicIntegerTest {
    @RepeatedTest(100)
    public void testCounter() {
        CounterWithAtomicInteger counterWithSynchronized = new CounterWithAtomicInteger();

        Runnable runnable = () -> {
            for (int i = 0; i < 10000; i++) {
                counterWithSynchronized.increment();
            }
        };

        var millisBefore = System.currentTimeMillis();
        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, 10).forEach(i -> CompletableFuture.runAsync(runnable, executorService));
        } catch (Exception _) {
        }
        var millisAfter = System.currentTimeMillis();

        Assertions.assertEquals(100000, counterWithSynchronized.getCount());
        System.out.println("Time: " + (millisAfter - millisBefore));
    }

}