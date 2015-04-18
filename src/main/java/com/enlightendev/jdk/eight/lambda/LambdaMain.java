package com.enlightendev.jdk.eight.lambda;

import java.util.Arrays;

/** */
public class LambdaMain {

    public static void main(String[] args) {

        String[] names = new String[]{"Andrew", "Zeta", "David", "Brian", "Carlie"};

        String[] sortedOld = new Sorting().sortOldMethod(names);

        System.out.println(Arrays.toString(sortedOld));

        String[] sortedNew = new Sorting().sortNewMethod(names);

        System.out.println(Arrays.toString(sortedNew));
    }
}
