package com.enlightendev.trxengine.trx.impl;

import com.enlightendev.trxengine.policy.IPolicyContext;
import com.enlightendev.trxengine.trx.Transaction;

/**
 * Abstract representation of deposit trx.
 *
 * Pattern: Template Method pattern in that child classes are responsible for
 * implementing the details of processing this transaction.
 *
 */
public abstract class AbstractDepositTransaction implements Transaction {

    protected IPolicyContext iPolicyContext;

    protected float depositAmount = 0.0f;

    public AbstractDepositTransaction(float depositAmount){
        this.depositAmount = depositAmount;
    }

    @Override
    public void processTransaction(IPolicyContext policyContext) {

        this.iPolicyContext = policyContext;

        processDeposit();
    }

    protected abstract void processDeposit();

    @Override
    public String getType() {
        return TRANSACTION_TYPE_DEPOSIT;
    }
}
