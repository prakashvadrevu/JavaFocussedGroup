package com.thoughtworks.javafocussedgroup.exercises.reflection.demo;

public class Main {

    public static void main(String args[]) {
        Person person = new Person();
        person.name = "Ram";
        person.age = 20;
        person.salary = 200.00f;

        Tson tson = new Tson();
        String serializedString = tson.serialize(person);
        System.out.println(serializedString);

    }

}
