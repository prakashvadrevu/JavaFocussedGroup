package com.thoughtworks.javafocussedgroup.exercises.annotations.demo;

public class Main {

    public static void main(String args[]) {
        Car car = new ObjectFactory().create(Car.class);
        car.check();

    }

}
