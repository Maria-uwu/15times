package com.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java -jar pipeline-paralelo.jar <NAME>");
            return;
        }

        String name = args[0];
        ExecutorService executor = Executors.newFixedThreadPool(5); // Pool de 5 hilos
        Random random = new Random();

        for (int i = 1; i <= 15; i++) {
            final int index = i;
            executor.submit(() -> {
                try {
                    int waitTime = random.nextInt(5) + 1; // Entre 1 y 5 segundos
                    Thread.sleep(waitTime * 1000);
                    System.out.println("Hello I am " + name + " and I am printing the number " + index);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
