package com.enlightendev.patterns.behavioral.observer.notifiers;

/**
 * Model the "independent" functionality with a "subject" abstraction
 * Created by jl25292 on 4/11/14.
 */
public class SimpleStateNotifierImpl extends AStateNotifier {

    @Override
    public int getState() {
        return state;
    }

    @Override
    public void setState(int in) {
        state = in;
        notifyStateObservers();
    }
}