package com.enlightendev.patterns.behavioral.state.ex1.states;

import com.enlightendev.patterns.behavioral.state.ex1.CeilingFanPullChain;

public class Off implements State {

    public void pull(CeilingFanPullChain wrapper) {
        wrapper.setState(new Low());
    }

    public String toString(){
        return "Off";
    }
}