package com.enlightendev.threading.reentrantlocks.ex1;

/**
 * Created by Juan on 5/19/14.
 */
public class Main {

    public static void main (String args[]){

        //shared print queue object
        PrintQueue printQueue=new PrintQueue();

        //create 10 job objects and 10 threads to run them
        Thread thread[]=new Thread[10];
        for (int i=0; i<10; i++){
            thread[i]=new Thread(new Job(printQueue),"Thread "+ i);
        }

        for (int i=0; i<10; i++){
            thread[i].start();
        }

    }
}
