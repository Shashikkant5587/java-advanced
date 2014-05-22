package com.enlightendev.concurrency.thread_basics.interupting;

import java.nio.file.NotDirectoryException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Example of interrupting a thread.
 * FileSearch occurs in its own thread, we can interrupt in 2 ways:
 *
 *      a - by pressing the return key after the thread starts -
 *      this stops the blocking call on main thread and proceeds to call
 *      interrupt on search thread.
 *
 *      b - by placing the searched for file in the search directory - when file is found
 *      search thread interrupts itself.
 *
 */
public class Main {

    public static void main(String[] args) throws NotDirectoryException {

        FileSearch searcher=new FileSearch("\\dev\\tmp\\","test.txt");
        Thread thread=new Thread(searcher);
        thread.start();

        //easy way to block and wait for action
        System.out.println("Press return key");
        new Scanner(System.in).nextLine();

        thread.interrupt();
    }
}
