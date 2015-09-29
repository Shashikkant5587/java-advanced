package com.enlightendev.generics;

import com.enlightendev.generics.interfaces.GenericInterfaceOneType;

import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class GenericsClient {

    public static void main(String[] args) {

        /**
         *  GenericInterfaceOneType<String> genericInterfaceOneTypeImpString = new GenericInterfaceOneType<String>() {
                @Override
                public void performAction(String action) {
                    System.out.println(action.length());
                }
            };
         */

        /**
         * Here we use a lambda expression to succinctly implement our performAction() method.
         *
         * Notice how lambda expression still understands data type of parameter passed to performAction() based on the
         * generic type String and List.
         */
        GenericInterfaceOneType<String> genericInterfaceOneTypeImpString = action -> System.out.println(action.length());
        genericInterfaceOneTypeImpString.performAction("Juan");


        List<String> names = Arrays.asList("Juan", "Joe", "Dave");

        GenericInterfaceOneType<List> genericInterfaceOneTypeImpList = action -> System.out.println(action.size());

        genericInterfaceOneTypeImpList.performAction(names);


    }
}
