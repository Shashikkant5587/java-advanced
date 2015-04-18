package com.enlightendev.trxengine.trx.impl;

import com.enlightendev.trxengine.policy.IPolicyContext;
import com.enlightendev.trxengine.trx.Transaction;

/**
 * Abstract representation of loan trx.
 *
 * Pattern: Template Method pattern in that child classes are responsible for
 * implementing the details of processing this transaction.
 *
 */
public abstract class AbstractLoanTransaction implements Transaction {

    protected IPolicyContext iPolicyContext;

    protected float loanAmount = 0.0f;

    public AbstractLoanTransaction(float loanAmount){
        this.loanAmount = loanAmount;
    }

    @Override
    public void processTransaction(IPolicyContext policyContext) {

        this.iPolicyContext = policyContext;

        float balance = getBalance();

        if(balance <= 0 || loanAmount > balance){
            return;
        }

        processLoan();
    }

    protected abstract float getBalance();

    protected abstract void processLoan();

    @Override
    public String getType() {
        return TRANSACTION_TYPE_LOAN;
    }
}
