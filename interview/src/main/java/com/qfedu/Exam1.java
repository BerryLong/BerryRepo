package com.qfedu;

import java.util.Comparator;

public class Exam1 {
    //  Comparable
    // Comparator
    @FunctionalInterface
    private interface CompOperation<T> {

        int doCompare(T o1, T o2);
    }

    private static <T> T _secondaryMax(T[] array, CompOperation<T> op) {
        assert array.length >= 2;
        T max = op.doCompare(array[0], array[1]) > 0 ? array[0] : array[1];
        T secondMax = op.doCompare(array[0], array[1]) > 0 ? array[1] : array[0];
        for (int i = 2; i < array.length; ++i) {
            if (op.doCompare(array[i], max) > 0) {
                secondMax = max;
                max = array[i];
            } else if (op.doCompare(array[i], secondMax) > 0) {
                secondMax = array[i];
            }
        }
        return secondMax;
    }

    public static <T extends Comparable<T>> T secondaryMax(T[] array) {
       return _secondaryMax(array, (o1, o2) -> { return o1.compareTo(o2); });
    }

    public static <T> T secondaryMax(T[] array, Comparator<T> comp) {
       return _secondaryMax(array, (o1, o2) -> { return comp.compare(o1, o2); });
    }

    public static void main(String[] args) {

    }
}
