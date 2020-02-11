package com.thoughtworks.javafocussedgroup.exercises.threads.demo;

import java.util.HashMap;
import java.util.Map;

public class BasicThread {

    public static void main(String[] args) {
        try {
            new BasicThread().go();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void go() throws InterruptedException {
        Map<Integer, Integer> map = new HashMap<>();
        Thread threadOne = create(map, 1);
        threadOne.start();
        threadOne.join();
        System.out.println("Map size: " + map.size());

    }

    public static Thread create(Map<Integer, Integer> map, int rangeStart) {
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
