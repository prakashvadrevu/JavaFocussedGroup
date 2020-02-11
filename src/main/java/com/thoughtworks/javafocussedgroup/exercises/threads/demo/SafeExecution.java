package com.thoughtworks.javafocussedgroup.exercises.threads.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SafeExecution {

    public static void main(String[] args) {
        try {
            new SafeExecution().go();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void go() throws InterruptedException {
        long startTime = System.currentTimeMillis();

        Map<Integer, Integer> map = new ConcurrentHashMap<>();

        Thread threadOne = create(map, 1);
        threadOne.start();

        Thread threadTwo = create(map, 100001);
        threadTwo.start();

        Thread threadThree = create(map, 200001);
        threadThree.start();

        threadOne.join();
        threadTwo.join();
        threadThree.join();

        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);

        System.out.println("Execution time: " + duration);
        System.out.println("Map size: " + map.size());

    }

    private static Thread create(Map<Integer, Integer> map, int rangeStart) {
        return new Thread() {
            @Override
            public void run() {
                int rangeEnd = rangeStart + 100000;
                for (int i=1 ; i< rangeEnd ; i++) {
                    map.put(i, i);
                }
            }
        };
    }

}
