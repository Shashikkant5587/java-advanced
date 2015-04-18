package com.enlightendev.trxengine.engine.impl;

import com.enlightendev.trxengine.engine.ITransactionEngine;
import com.enlightendev.trxengine.policy.IPolicyContext;
import com.enlightendev.trxengine.trx.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 */
public abstract class ATransactionEngine implements ITransactionEngine {

    /**
     *
     */
    protected IPolicyContext policyContext;

    /**
     * Container for transactions that need to be processed.
     */
    protected List<Transaction> transactions = new ArrayList<>();

    /**
     *
     * @param policyContext
     */
    public ATransactionEngine(IPolicyContext policyContext){
        this.policyContext = policyContext;
    }


    //----- ITransactionEngine


    @Override
    public void add(Transaction trx) {
        transactions.add(trx);
    }

    @Override
    public void processGiven(List<Transaction> transactions) {}

    @Override
    public void setPolicyContext(IPolicyContext policyContext) {
        this.policyContext = policyContext;
    }

    @Override
    public IPolicyContext getPolicyContext() {
        return policyContext;
    }
}
