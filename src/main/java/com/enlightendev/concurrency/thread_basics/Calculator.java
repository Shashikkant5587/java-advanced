package com.enlightendev.concurrency.thread_basics;

/**
 * Created by jl25292 on 5/22/14.
 */
public class Calculator implements Runnable{

    private int number;

    public Calculator(int number) {
        this.number=number;
    }

    @Override
    public void run() {
        for (int i=1; i<=10; i++){
            System.out.printf("%s: %d * %d = %d\n", Thread.currentThread().getName(), number, i, i * number);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
