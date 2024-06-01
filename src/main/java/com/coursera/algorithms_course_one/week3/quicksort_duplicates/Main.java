package com.coursera.algorithms_course_one.week3.quicksort_duplicates;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = {1, 9, 5, 5, 2, 7, 5, 9, 2, 9, 5, 0, 6};
        System.out.println("before sorting: ");
        List.of(arr).forEach(x -> System.out.print("- " + x));

        Quicksort3Way.sort(arr);

        System.out.println("\nafter sort");
        List.of(arr).forEach(x -> System.out.print("- " + x));
    }
}