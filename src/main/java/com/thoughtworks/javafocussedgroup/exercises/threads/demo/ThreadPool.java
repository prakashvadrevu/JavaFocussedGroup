package com.thoughtworks.javafocussedgroup.exercises.threads.demo;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);//creating a pool of 5 threads

        long startTime = System.currentTimeMillis();
        executor.execute(new BasicThread().create(new HashMap<>(), 1));
        executor.execute(new BasicThread().create(new HashMap<>(), 1));
        executor.execute(new BasicThread().create(new HashMap<>(), 1));
        executor.execute(new BasicThread().create(new HashMap<>(), 1));
        executor.execute(new BasicThread().create(new HashMap<>(), 1));

        executor.shutdown();
        while (!executor.isTerminated()) {   }

        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.println("Execution time: " + duration);

    }

}
