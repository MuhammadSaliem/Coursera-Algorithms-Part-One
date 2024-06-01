package com.coursera.algorithms_course_one.week3.quicksort;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = {1, 5, 2, 7, 9, 2, 0, 6};
        System.out.println("before sorting: ");
        List.of(arr).forEach(x -> System.out.print("- " + x));

        Quicksort.sort(arr);

        System.out.println("\nafter sort");
        List.of(arr).forEach(x -> System.out.print("- " + x));
    }
}