package com.enlightendev.patterns.behavioral.state.ex1.states;

import com.enlightendev.patterns.behavioral.state.ex1.CeilingFanPullChain;

public class Low implements State {

    public void pull(CeilingFanPullChain wrapper) {
        wrapper.setState(new Medium());
    }

    public String toString(){
        return "Low";
    }
}

