package com.enlightendev.trxengine.trx.impl;

/**
 * COLILoan trx
 */
public class COLIDepositTransaction extends AbstractDepositTransaction {

    public COLIDepositTransaction(float depositAmount) {
        super(depositAmount);
    }

    @Override
    protected void processDeposit() {
        System.out.println("Processing coli deposit!! Adding deposit amount: " + depositAmount);
        iPolicyContext.setCurrentBalance(iPolicyContext.getCurrentBalance() + depositAmount);
    }
}
