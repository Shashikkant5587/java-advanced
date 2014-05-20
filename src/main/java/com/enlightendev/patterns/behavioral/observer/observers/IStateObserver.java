package com.enlightendev.patterns.behavioral.observer.observers;

/**
 * Model the "dependent" functionality with "observer" hierarchy
 * Created by jl25292 on 4/11/14.
 */
public interface IStateObserver {

    public void updateState(int state);

}
