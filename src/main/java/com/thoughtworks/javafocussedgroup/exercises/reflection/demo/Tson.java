package com.thoughtworks.javafocussedgroup.exercises.reflection.demo;

import java.lang.reflect.Field;

import static java.lang.String.format;

public class Tson {

    public <T> String serialize(T source) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('{');
            for (Field field : source.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                stringBuilder.append(format("%s:%s ", field.getName(), field.get(source)));
            }
            stringBuilder.append('}');
            return stringBuilder.toString();

        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);

        }
    }

}
