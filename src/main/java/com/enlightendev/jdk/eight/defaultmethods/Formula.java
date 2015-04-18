package com.enlightendev.jdk.eight.defaultmethods;

interface Formula {
    double calc(int a);

    default double sqrt(int a){
        return Math.sqrt(a);
    }
}

