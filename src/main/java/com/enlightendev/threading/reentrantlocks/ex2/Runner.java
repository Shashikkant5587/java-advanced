package com.enlightendev.threading.reentrantlocks.ex2;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * With properly synchronized access to this shared instance we should reach a count of 20000 when 2 threads act
 * concurrently on this shared object. Without synchronized access we are unable to determine the final output.
 *
 * This object is synchronized using a reentrant lock in the critical section of the code. Run the app with and without
 * the use of the reentrant lock to view output.
 *
 *
 * NOTE: to further illustrate thread coordination uncomment and experiment with the code that is commented out
 * in the threadIncrement methods.
 *
 * Created by Juan on 5/20/14.
 */
public class Runner {

    /**
     *
     */
    private int count = 0;

    /**
     * Once a thread gets this lock
     */
    private Lock lock = new ReentrantLock(true);

    /**
     * get condition object from the lock
     */
    private Condition condition = lock.newCondition();

    /**
     *
     */
    private void increment(){
        for (int i = 0; i < 10000; i++){
            count++;
        }
    }

    /**
     *
     *
     * @throws InterruptedException
     */
    public void threadOneIncrement() throws InterruptedException{
        lock.lock();

        //System.out.println("Waiting ...... !");
        /**
         * condition.await() does same as wait inside a synchronized block.
         * this hands over control of the lock essentially unlocking and allowing another thread access
         * we continue once signaled (condition.signal()).
         */
        //condition.await();

        //System.out.println("Woken up!");

        try{
            increment();
        }finally {
            //use finally block to ensure we unlock
            lock.unlock();
        }

        //System.out.println("Finished T1 increment!");
    }

    public void threadTwoIncrement() throws InterruptedException{

        //Thread.sleep(1000);

        lock.lock(); //wake up after sleep and get lock

        //contrived way to block and wait for action
        //System.out.println("Press return key");
        //new Scanner(System.in).nextLine();

        //should wake up first thread, if we leave this call out we never wake first thread.
        //condition.signal();

        try{
            increment();
        }finally {
            //use finally block to ensure we unlock
            lock.unlock();
        }

        //System.out.println("Finished T2 increment!");
    }

    public void finished(){
        System.out.println("Count is: " + count);
    }
}
