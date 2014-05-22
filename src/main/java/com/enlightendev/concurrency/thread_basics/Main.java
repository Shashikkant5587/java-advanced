package com.enlightendev.concurrency.thread_basics;

/**
 * Created by jl25292 on 5/22/14.
 */
public class Main {

    public static void main(String[] args) {

        for (int i=1; i<=10; i++){
            Calculator calculator=new Calculator(i);
            Thread thread = new Thread(calculator);
            thread.start();
        }

        System.out.printf("FINISHED THREAD: %s\n", Thread.currentThread().getName());
    }
}
