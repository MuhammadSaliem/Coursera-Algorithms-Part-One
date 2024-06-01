package com.coursera.algorithms_course_one.week2.elementary_sorts;

import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.StdRandom;

public class Main {
    public static void main(String[] args) {
        Integer arr[] = generateRandomIntegerArray(1000000);

        long start = System.currentTimeMillis();
        Quick.sort(arr);
        System.out.println((System.currentTimeMillis() - start) / 1000.00);
    }

    public static Integer[] generateRandomIntegerArray(int size) {
        Integer[] arr = new Integer[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = StdRandom.uniformInt(size);
        }

        return arr;
    }
}