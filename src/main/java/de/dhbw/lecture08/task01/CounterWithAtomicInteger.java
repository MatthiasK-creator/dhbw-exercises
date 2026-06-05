package de.dhbw.lecture08.task01;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterWithAtomicInteger {

    private final AtomicInteger count = new AtomicInteger(0);

    public synchronized void increment() {
        count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }

}
