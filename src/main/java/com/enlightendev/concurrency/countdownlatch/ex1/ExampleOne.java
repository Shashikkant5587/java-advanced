package com.enlightendev.concurrency.countdownlatch.ex1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatch: A synchronization aid that allows one or more threads to wait until a set of operations being
 * performed in other threads completes.
 */
public class ExampleOne {

    /**
     *
     */
    static class Worker implements Runnable {

        /**
         * CountDownLatches used to communicate state
         */
        private final CountDownLatch startSignal;
        private final CountDownLatch doneSignal;

        /**
         * The shared latches
         * @param startSignal
         * @param doneSignal
         */
        Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
            this.startSignal = startSignal;
            this.doneSignal = doneSignal;
        }

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p/>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public void run() {
            try {
                //indicate we dont want to actually start until we get go ahead from start signal
                startSignal.await();

                //this never gets called until start signal
                doWork();

                //communicate completion of this worker task
                doneSignal.countDown();
            } catch (InterruptedException ex) {

            } // return;

        }

        void doWork() {

            System.out.printf("Worker is doing his work!!: %s\n", Thread.currentThread().getName());
        }
    }

    /**
     * Main thread that starts workers
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

        int N = 5;
        
        //The first is a start signal that prevents any worker from proceeding
        // until the driver is ready for them to proceed;
        // worker threads call await in order to wait for signal
        CountDownLatch startSignal = new CountDownLatch(1);

        //The second is a completion signal that allows the driver to wait until all workers have completed.
        //worker threads will countdown this latch to indicate completion
        CountDownLatch doneSignal = new CountDownLatch(N);

        //notice how despite the fact that thread start is called workers don't work until start signal is received.
        for (int i = 0; i < N; i++) {
            new Thread(new Worker(startSignal,doneSignal)).start();
        }

        doSomethingElse();

        //If we don't call countdown we don't create a start signal and workers will never start
        startSignal.countDown();

        doSomethingElse();

        //we don't get past this point till all threads are done. If we comment out it is possible to get
        //subsequent print out before all threads finish
        doneSignal.await();

        System.out.printf("FINISHED: %s\n", Thread.currentThread().getName());

    }

    static void doSomethingElse() throws InterruptedException{

        System.out.printf("Doing something else: %s\n", Thread.currentThread().getName());
        //TimeUnit.SECONDS.sleep(1);

    }
}


