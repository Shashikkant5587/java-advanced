package com.enlightendev.algorithms.princeton;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Created by Juan on 5/3/14.
 */
public class Average {

    public static void main(String[] args){
        double sum = 0.0;
        int cnt = 0;

        while(!StdIn.isEmpty()){
            sum += StdIn.readDouble();
            cnt++;
        }

        double average = sum / cnt;
        StdOut.printf("Average is %.5f\n ", average);
    }
}
