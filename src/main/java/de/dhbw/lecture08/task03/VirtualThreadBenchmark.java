package de.dhbw.lecture08.task03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreadBenchmark {
    private static final int TASKS = 10_000;

    static void main(String[] args) throws Exception {

        System.out.println("=== Variante A: FixedThreadPool(100) ===");
        runBenchmark(Executors.newFixedThreadPool(100));

        System.out.println("\n=== Variante B: Virtual Threads ===");
        runBenchmark(Executors.newVirtualThreadPerTaskExecutor());
    }

    // Informationen:
    // Bei einem Plattform-Thread: Thread.sleep(100) blockiert ein echter Betriebssystem-Thread.
    // Bei einem Virtual Thread:Thread.sleep(100) führt zu:
    //    Virtual Thread wird geparkt
    //    Carrier Thread wird freigegeben
    //    Carrier kann andere Virtual Threads ausführen
    //    Nach 100 ms wird der Virtual Thread wieder eingeplant
    // Dadurch können Zehntausende wartende Tasks gleichzeitig existieren.

    // Erkläre, warum dieselbe Strategie für CPU-Last NICHT funktionieren würde:
    // Bei CPU-Last
    // Betrachte statt sleep():
    //  for (long i = 0; i < 1_000_000_000L; i++) {
    //    Math.sqrt(i);
    //  }
    // Dann gilt: Jeder Task benötigt echte CPU-Zeit. Ein Virtual Thread kann nicht rechnen, ohne einen Carrier Thread zu benutzen.
    // Carrier Threads entsprechen letztlich den verfügbaren CPU-Kernen.

    private static void runBenchmark(ExecutorService executor) throws Exception {

        long start = System.currentTimeMillis();

        List<Runnable> tasks = new ArrayList<>();

        for (int i = 0; i < TASKS; i++) {
            tasks.add(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        for (Runnable task : tasks) {
            executor.submit(task);
        }

        executor.shutdown();

        while (!executor.isTerminated()) {
            Thread.sleep(10);
        }

        long end = System.currentTimeMillis();

        System.out.println("Dauer: " + (end - start) + " ms");
    }

}
