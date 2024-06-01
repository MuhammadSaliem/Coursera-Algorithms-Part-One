package com.coursera.algorithms_course_one.week3.quicksort_duplicates;

import com.coursera.algorithms_course_one.util.SortUtils;

import edu.princeton.cs.algs4.StdRandom;

public class Quicksort3Way {

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo)
            return;

        int lt = lo, gt = hi;
        Comparable v = a[lo];
        int i = lo;

        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0)
                SortUtils.exch(a, lt++, i++);
            else if (cmp > 0)
                SortUtils.exch(a, i, gt--);
            else
                i++;
        }

        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

}
