package com.enlightendev.patterns.behavioral.state.ex1;

import com.enlightendev.patterns.behavioral.state.ex1.states.Off;
import com.enlightendev.patterns.behavioral.state.ex1.states.State;

/**
 *
 * Created by jl25292 on 4/14/14.
 */
public class CeilingFanPullChain {

    private State currentState;

    public CeilingFanPullChain() {
        currentState = new Off();
    }

    public void setState(State s) {
        currentState = s;
        System.out.println("Current state changed to: " + currentState);
    }

    public void pull() {
        currentState.pull(this);
    }
}
