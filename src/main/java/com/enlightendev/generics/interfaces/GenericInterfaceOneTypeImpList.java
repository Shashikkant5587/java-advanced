package com.enlightendev.generics.interfaces;

import java.util.List;

/**
 *
 */
public class GenericInterfaceOneTypeImpList implements GenericInterfaceOneType<List<String>> {

    @Override
    public void performAction(List<String> list) {

        System.out.println(list.size());

    }
}
