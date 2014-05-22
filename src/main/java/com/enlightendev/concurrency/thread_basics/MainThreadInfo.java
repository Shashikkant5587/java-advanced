package com.enlightendev.concurrency.thread_basics;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by jl25292 on 5/22/14.
 */
public class MainThreadInfo {

    public static void main(String[] args) {

        Thread threads[]=new Thread[10];
        Thread.State status[]=new Thread.State[10];

        for (int i=0; i<10; i++){
            threads[i]=new Thread(new Calculator(i));

            if ((i%2)==0){
                threads[i].setPriority(Thread.MAX_PRIORITY);
            } else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("Thread "+i);
        }

        PrintWriter pw = null;
        try {
            FileWriter file = new FileWriter("\\dev\\log.txt");
            pw = new PrintWriter(file);
        }catch (IOException e){
            System.out.println("EX: " + e);
        }

        for (int i=0; i<10; i++){
            threads[i].start();
        }

        for (int i=0; i<10; i++){
            pw.println("Main : Status of Thread "+i+" : "  +  threads[i].getState());
            status[i]=threads[i].getState();
        }

        boolean finish=false;
        while (!finish) {
            for (int i=0; i<10; i++){
                if (threads[i].getState()!=status[i]) {
                    writeThreadInfo(pw, threads[i],status[i]);
                    status[i]=threads[i].getState();
                }
            }
            finish=true;
            for (int i=0; i<10; i++){
                finish=finish &&(threads[i].getState() == Thread.State.TERMINATED);
            }
        }

        System.out.printf("FINISHED THREAD: %s\n", Thread.currentThread().getName());
    }

    private static void writeThreadInfo(PrintWriter pw, Thread thread, Thread.State state) {
        pw.printf("Main : Id %d - %s\n",thread.getId(),thread.getName());
        pw.printf("Main : Priority: %d\n",thread.getPriority());
        pw.printf("Main : Old State: %s\n",state);
        pw.printf("Main : New State: %s\n",thread.getState());
        pw.printf("Main : ************************************\n");
    }
}
