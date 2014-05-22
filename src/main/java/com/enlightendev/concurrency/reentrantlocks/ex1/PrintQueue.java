package com.enlightendev.concurrency.reentrantlocks.ex1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * When we want to implement a critical section using locks and guarantee that only one execution
 * thread runs a block of code, we have to create a ReentrantLock object. At the beginning of the
 * critical section, we have to get the control of the lock using the lock() method. When a thread
 * (A) calls this method, if no other thread has the control of the lock, the method gives the
 * thread (A) the control of the lock and returns immediately to permit the execution of the
 * critical section to this thread. Otherwise, if there is another thread (B) executing the
 * critical section controlled by this lock, the lock() method puts the thread (A) to sleep
 * until the thread (B) finishes the execution of the critical section.
 * Created by Juan on 5/19/14.
 */
public class PrintQueue {

    private final Lock queueLock=new ReentrantLock();


    /**
     *
     * @param document
     */
    public void printJob(Object document){

        queueLock.lock();

        //simulate print job
        try {

            //random duration
            Long duration=(long)(Math.random()*10000);

            System.out.println(Thread.currentThread().getName()+ ": " +
                    "PrintQueue: Printing a Job during "+(duration/1000) + " seconds");

            Thread.sleep(duration);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            /**
             * At the end of the critical section, we have to use the unlock() method to free
             * the control of the lock and allow the other threads to run this critical section.
             * If you don't call the unlock() method at the end of the critical section, the other
             * threads that are waiting for that block will be waiting forever, causing a
             * deadlock situation.
             */
            queueLock.unlock();
        }
    }
}
