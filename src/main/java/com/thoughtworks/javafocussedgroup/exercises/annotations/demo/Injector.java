package com.thoughtworks.javafocussedgroup.exercises.annotations.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {

    public <T> void inject(T objectToInject) {
        try {
            for (Field field : objectToInject.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(Inject.class)) {
                    Class<?> type = field.getType();
                    Constructor<?> cons = type.getDeclaredConstructor();
                    Object newInstance = cons.newInstance();
                    field.set(objectToInject, newInstance);
                }
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
