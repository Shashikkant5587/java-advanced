package com.enlightendev.concurrency.semaphores.ex1;

import java.util.concurrent.Semaphore;

/**
 *
 */
public class Connection {

    /**
     * Singleton instance
     */
    private static Connection instance = new Connection();

    /**
     * limit connections to 10
     * true = thread waiting the longest gets permit first.
     */
    private Semaphore sem = new Semaphore(10, true);

    /**
     * Connection count
     */
    private int connections = 0;

    private Connection() {}

    /**
     * Get singleton
     * @return singleton instance
     */
    public static Connection getInstance() {
        return instance;
    }

    /**
     *
     */
    public void connect() {

        try {
            // get permit decrease the sem value, if 0 wait for release
            sem.acquire();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        try {

            doConnect();
        } finally {
            sem.release();// release permit, increase the sem value and activate waiting thread
        }
    }

    public void doConnect() {

        synchronized (this) { //atomic
            connections++;
            System.out.println("Current connections (max 10 allowed): " + connections);
        }

        try {
            //do work
            System.out.println("Working on connections " + Thread.currentThread().getName());
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //when exit doConnect decrement number of connections
        synchronized (this) {//atamoic
            connections--;
            System.out.println("I'm done " + Thread.currentThread().getName() + " Connection is released , connection count: " + connections);
        }
    }
}
