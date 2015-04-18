package com.enlightendev.jdk.eight.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 */
public class Sorting {

    public String[] sortOldMethod(String[] unsorted){

        List<String> names = Arrays.asList(unsorted);

        /**
         * The static utility method Collections.sort accepts a list and a comparator in order to sort the elements
         * of the given list. You often find yourself creating anonymous comparators and pass them to the sort method.
         */
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        return names.toArray(new String[names.size()]);
    }

    /**
     * Using Lambda expressions
     * @param unsorted
     * @return
     */
    public String[] sortNewMethod(String[] unsorted){
        List<String> names = Arrays.asList(unsorted);

        /**
         * Instead of creating anonymous objects all day long, Java 8 comes with a much shorter syntax, lambda expressions:
         *
         Collections.sort(names, (String a, String b) -> {
            return a.compareTo(b);
         });

         For one line method bodies you can skip both the braces {} and the return keyword.
         Collections.sort(names, (String a, String b) -> b.compareTo(a));

         The java compiler is aware of the parameter types so you can skip them as well.
         Collections.sort(names, (a, b) -> b.compareTo(a));
         */

        Collections.sort(names, (a, b) -> b.compareTo(a));
        return names.toArray(new String[names.size()]);
    }
}
