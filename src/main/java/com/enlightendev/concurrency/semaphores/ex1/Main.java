package com.enlightendev.concurrency.semaphores.ex1;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * https://github.com/Beerkay/JavaMultiThreading
 * https://github.com/Beerkay/JavaMultiThreading/tree/master/JavaMultiThreadingCodes/src/Semaphores_12
 */
public class Main {

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 20; i++) {

            executor.submit(new Runnable() {
                public void run() {
                    Connection.getInstance().connect();
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
    }

}
