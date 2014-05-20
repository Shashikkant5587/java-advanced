package com.enlightendev.patterns.behavioral.state.ex1.states;

import com.enlightendev.patterns.behavioral.state.ex1.CeilingFanPullChain;

public interface State {
    void pull(CeilingFanPullChain wrapper);
}