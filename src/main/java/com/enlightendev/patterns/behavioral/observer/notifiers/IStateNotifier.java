package com.enlightendev.patterns.behavioral.observer.notifiers;

import com.enlightendev.patterns.behavioral.observer.observers.IStateObserver;

/**
 * Created by jl25292 on 4/11/14.
 */
public interface IStateNotifier {

    void addStateObserver(IStateObserver o);

    void setState(int in);

    int getState();

    void notifyStateObservers();
}
