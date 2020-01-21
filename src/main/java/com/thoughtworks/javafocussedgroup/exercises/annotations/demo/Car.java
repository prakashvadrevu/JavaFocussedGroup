package com.thoughtworks.javafocussedgroup.exercises.annotations.demo;

public class Car {

    @Inject
    public Engine engine;

    public void check() {
        System.out.println("Checking for Engine...");
        engine.check();
    }

}
