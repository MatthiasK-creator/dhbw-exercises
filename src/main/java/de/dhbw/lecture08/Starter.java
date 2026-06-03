package de.dhbw.lecture08;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Starter {
    static void main() throws InterruptedException {
        Worker worker = new Worker();

        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();

        executorService.execute(worker);

        Thread.sleep(2000);
        worker.stop();

        executorService.shutdown();
    }
}

