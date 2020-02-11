package com.thoughtworks.javafocussedgroup.exercises.threads.demo;

public class Main {

    public static void main(String[] args) {
        try {

            System.out.println("Sequential");
            new SequentialExecution().go();

            System.out.println();
            System.out.println();

            System.out.println("Parallel");
            new ConcurrentExecution().go();

            System.out.println();
            System.out.println();

            System.out.println("Safe");
            new SafeExecution().go();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
