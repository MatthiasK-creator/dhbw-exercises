package de.dhbw.lecture01;

import java.util.Random;

public class StandardDeviation {
    static void main(String[] args) {
        int n = 100;
        Random rnd = new Random();
        int[] x = new int[n];

        // generate random numbers and calculate average
        int sum = 0;
        for (int i = 0; i < x.length; i++) {
            x[i] = rnd.nextInt(11); // 0..10
            sum += x[i]; // sum up the x[i]
        }
        double average = 1. * sum / n;
        System.out.println("Mittelwert: " + average);

        // calculate standard deviation
        double devSum = 0;
        for (int i = 0; i < x.length; i++) {
            devSum += Math.pow(x[i] - average, 2);
        }
        double deviation = Math.sqrt(devSum / (n - 1));
        System.out.println("Standardabweichung: " + deviation);
    }
}
