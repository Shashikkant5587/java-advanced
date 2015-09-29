package com.enlightendev.generics.interfaces;

/**
 *
 */
public class GenericInterfaceOneTypeImpString implements GenericInterfaceOneType<String> {

    @Override
    public void performAction(String string) {

        System.out.println(string.length());

    }
}
