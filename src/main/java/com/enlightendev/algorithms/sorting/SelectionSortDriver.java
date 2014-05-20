package com.enlightendev.algorithms.sorting;

import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.introcs.StdOut;

/**
 * Created by Juan on 5/8/14.
 */
public class SelectionSortDriver {

    public static void main(String[] args) {

        Integer[] a = {7, 3, 66, 3, -5, 22, -77, 2};
        Selection.sort(a);
        show(a);
    }

    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }
}
