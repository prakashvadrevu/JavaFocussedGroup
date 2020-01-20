package com.thoughtworks.javafocussedgroup.exercises.generics;

import java.util.*;

/*
 * TODO: Implement this class
 */
public class FileConverter {

    private Map<Class<? extends File>, Map<Class<? extends File>, Converter>> converters;

    public FileConverter() {
        converters = new HashMap<>();
    }

    public void add(Converter converter) {
        Map<Class<? extends File>, Converter> toList = converters.get(converter.from());
        if (toList == null) {
            toList = new HashMap<>();
        }
        toList.put(converter.to(), converter);
        converters.put(converter.from(), toList);
    }


    public <T extends File, U extends File> U convert(T from, Class<U> clazz) {
        return convert(from, clazz, new HashSet<>());
    }

    public <T extends File, U extends File> U convert(T from, Class<U> clazz, Set<Class> usedConverters) {
        if (!converters.containsKey(from.getClass())) { throw new NoConverterFoundException(); }
        U output = convertFile(from, clazz, usedConverters);

        if (output == null) {
            Map<Class<? extends File>, Converter> convertersAvailableForSourceFile = converters.get(from.getClass());
            for (Map.Entry<Class<? extends File>, Converter> entry : convertersAvailableForSourceFile.entrySet()) {
                if (usedConverters.contains(from.getClass())) {
                    continue;
                }
                usedConverters.add(entry.getKey());
                File file = entry.getValue().convert(from);
                U convertedFile = convert(file, clazz, usedConverters);
                if (convertedFile == null) {
                    continue;
                }
                return convertedFile;
            }
            throw new NoConverterFoundException();

        } else {
            return output;

        }
    }

    private <T extends File, U extends File> U convertFile(File from, Class<U> clazz, Set<Class> usedConverters) {
        Map<Class<? extends File>, Converter> c = converters.get(from.getClass());
        if (c == null) { return null; }
        Converter converter = c.get(clazz);
        usedConverters.add(from.getClass());
        if (converter == null || usedConverters.contains(converter)) {
            return null;
        }
        return (U) converter.convert(from);
    }

    public static class NoConverterFoundException extends RuntimeException {}

}
