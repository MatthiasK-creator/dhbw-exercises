package de.dhbw.lecture08.live_coding_snippets;

class Worker implements Runnable {
    private volatile boolean running = true;

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
        }
        System.out.println("Gestoppt");
    }
}
