package com.enlightendev.patterns.behavioral.observer.observers;

/**
 * Created by jl25292 on 4/11/14.
 */
public class BinObserver implements IStateObserver {

    @Override
    public void updateState(int state) {
        System.out.print( "  " + Integer.toBinaryString( state) );
    }
}
