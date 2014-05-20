package com.enlightendev.patterns.behavioral.observer;

import com.enlightendev.patterns.behavioral.observer.notifiers.IStateNotifier;
import com.enlightendev.patterns.behavioral.observer.notifiers.SimpleStateNotifierImpl;
import com.enlightendev.patterns.behavioral.observer.observers.BinObserver;
import com.enlightendev.patterns.behavioral.observer.observers.HexObserver;
import com.enlightendev.patterns.behavioral.observer.observers.OctObserver;

import java.util.Scanner;

/**
 * http://www.vincehuston.org/dp/observer.html
 * Created by jl25292 on 4/11/14.
 */
public class ObserverMain {

    public static void main( String[] args ) {

        IStateNotifier notifier = new SimpleStateNotifierImpl();

        //Client configures the number and type of Observers
        notifier.addStateObserver(new HexObserver());
        notifier.addStateObserver(new OctObserver());
        notifier.addStateObserver(new BinObserver());

        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.print("\nEnter a number: ");
            String line = s.nextLine();

            if(line.equalsIgnoreCase("quit")){
                break;
            }

            notifier.setState(Integer.parseInt(line));
        }
    }
}
