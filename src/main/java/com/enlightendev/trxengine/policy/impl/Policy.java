package com.enlightendev.trxengine.policy.impl;

import com.enlightendev.trxengine.policy.IPolicyContext;

/**
 *
 */
public class Policy implements IPolicyContext {

    private float startingBalance = 0.0f;
    private float currentBalance = 0.0f;

    private String policyId = "";


    public Policy(String policyId, float startingBalance){
        this.policyId = policyId;
        this.startingBalance = startingBalance;
        this.currentBalance = startingBalance;
    }

    //POLICY CTX Interface
    @Override
    public float getCurrentBalance() {
        return currentBalance;
    }

    @Override
    public void setCurrentBalance(float currentBalance) {
        this.currentBalance = currentBalance;
    }

}
