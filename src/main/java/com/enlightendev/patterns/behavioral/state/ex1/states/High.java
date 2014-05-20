package com.enlightendev.patterns.behavioral.state.ex1.states;

import com.enlightendev.patterns.behavioral.state.ex1.CeilingFanPullChain;

public class High implements State {

    public void pull(CeilingFanPullChain wrapper) {
        wrapper.setState(new Off());
    }

    public String toString(){
        return "High";
    }
}