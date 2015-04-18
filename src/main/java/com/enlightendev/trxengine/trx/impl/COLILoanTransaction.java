package com.enlightendev.trxengine.trx.impl;

/**
 * COLILoan trx
 */
public class COLILoanTransaction extends AbstractLoanTransaction {

    public COLILoanTransaction(float loanAmount) {
        super(loanAmount);
    }

    @Override
    protected float getBalance() {
        return iPolicyContext.getCurrentBalance();
    }

    @Override
    protected void processLoan() {
        System.out.println("Processing coli loan!! Subtracting loan amount: " + loanAmount);
        iPolicyContext.setCurrentBalance(iPolicyContext.getCurrentBalance() - loanAmount);
    }
}
