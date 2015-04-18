package com.enlightendev.trxengine.engine.impl;

import com.enlightendev.trxengine.policy.IPolicyContext;
import com.enlightendev.trxengine.trx.Transaction;

/**
 *
 */
public class COLITransactionEngine extends ATransactionEngine {

    public COLITransactionEngine(IPolicyContext policyContext){
        super(policyContext);
    }

    @Override
    public void processAll() {

        for(Transaction transaction: transactions){
            transaction.processTransaction(policyContext);
        }

    }

    @Override
    public String getName() {
        return "COLITrxEngine";
    }
}
