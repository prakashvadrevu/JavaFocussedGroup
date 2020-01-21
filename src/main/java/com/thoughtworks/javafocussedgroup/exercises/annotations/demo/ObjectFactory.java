package com.thoughtworks.javafocussedgroup.exercises.annotations.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ObjectFactory {

    Injector injector = new Injector();

    public <T> T create(Class<T> clazz) {
        try {
            Constructor<?> cons = clazz.getDeclaredConstructor();
            Object newInstance = cons.newInstance();
            injector.inject(newInstance);
            return (T) newInstance;

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

}
