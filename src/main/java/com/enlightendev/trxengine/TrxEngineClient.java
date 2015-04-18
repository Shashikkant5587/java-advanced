package com.enlightendev.trxengine;

import com.enlightendev.trxengine.engine.ITransactionEngine;
import com.enlightendev.trxengine.engine.TransactionEngineFactory;
import com.enlightendev.trxengine.policy.impl.Policy;
import com.enlightendev.trxengine.trx.Transaction;
import com.enlightendev.trxengine.trx.TransactionFactory;

/**
 * Notice how this client simply interacts w/ interfaces and uses factory classes to create needed abstractions.
 *
 */
public class TrxEngineClient {

    public static void main(String[] args) {

        //get policy
        Policy policy = new Policy("VG001", 10000.0f);

        System.out.println("Starting Balance: " + policy.getCurrentBalance());

        //create the trxs - we use a factory that hides the impl details of creating a specific trx type.
        TransactionFactory transactionFactory = TransactionFactory.getInstance();

        Transaction loanTrx = transactionFactory.createLoanTransaction(3000.0f);
        Transaction depositTrx = transactionFactory.createDepositTransaction(500.0f);

        ITransactionEngine trxEngine = TransactionEngineFactory.getTransactionEngine("COLI", policy);

        trxEngine.add(loanTrx);
        trxEngine.add(depositTrx);

        //process trxs
        trxEngine.processAll();

        System.out.println("Current Balance: " + policy.getCurrentBalance());

    }
}
