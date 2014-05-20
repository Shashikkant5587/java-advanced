package com.enlightendev.patterns.behavioral.state.ex1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        CeilingFanPullChain chain = new CeilingFanPullChain();

        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.print("Press ");
            String line = s.nextLine();

            if(line.equalsIgnoreCase("quit")){
                break;
            }

            chain.pull();
        }
    }
}
