package de.dhbw.lecture08.task01;

public class CounterWithSynchronized {

    private int count = 0;

    public synchronized void increment(){
        count++;
    }

    public int getCount() {
        return count;
    }

}
