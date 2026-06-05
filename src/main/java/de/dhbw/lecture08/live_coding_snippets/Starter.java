package de.dhbw.lecture08.live_coding_snippets;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Starter {
    /**
     * Showcase von volatile, ohne volatile terminiert diese main-Methode nicht.
     * Mit volatile terminert die Main-Methode nach 2s durch das Update vom boolean-Flag innerhalb {@link Worker#stop()}
     * @throws InterruptedException
     */
    static void main() throws InterruptedException {
        Worker worker = new Worker();

        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();

        executorService.execute(worker);

        Thread.sleep(2000);
        worker.stop();

        executorService.shutdown();
    }
}

