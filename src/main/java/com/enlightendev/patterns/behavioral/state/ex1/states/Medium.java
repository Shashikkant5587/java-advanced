package com.enlightendev.patterns.behavioral.state.ex1.states;

import com.enlightendev.patterns.behavioral.state.ex1.CeilingFanPullChain;

public class Medium implements State {

    public void pull(CeilingFanPullChain wrapper) {
        wrapper.setState(new High());
    }

    public String toString(){
        return "Medium";
    }
}
