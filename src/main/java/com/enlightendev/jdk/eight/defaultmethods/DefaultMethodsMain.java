package com.enlightendev.jdk.eight.defaultmethods;

/**
 *
 */
public class DefaultMethodsMain {

    public static void main(String[] args) {

        Formula formula = new Formula() {
            @Override
            public double calc(int a) {
                return a * 5;
            }
        };

        System.out.println(formula.calc(5));
        System.out.println(formula.sqrt(100));
    }
}
