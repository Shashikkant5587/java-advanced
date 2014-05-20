package com.enlightendev.patterns.behavioral.observer.notifiers;

import com.enlightendev.patterns.behavioral.observer.observers.IStateObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * Model the "independent" functionality with a "subject" abstraction
 * Created by jl25292 on 4/11/14.
 */
public abstract class AStateNotifier implements IStateNotifier {

    private List<IStateObserver> observers = new ArrayList<IStateObserver>();
    protected int state;

    public void addStateObserver(IStateObserver o) {
        observers.add(o);
    }

    @Override
    public abstract int getState();

    @Override
    public abstract void setState(int in);

    @Override
    public void notifyStateObservers() {
        for(IStateObserver observer: observers){
            observer.updateState(state);
        }
    }
}