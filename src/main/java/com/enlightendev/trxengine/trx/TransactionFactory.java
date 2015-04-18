package com.enlightendev.trxengine.trx;

import com.enlightendev.trxengine.trx.impl.COLIDepositTransaction;
import com.enlightendev.trxengine.trx.impl.COLILoanTransaction;

/**
 *
 * PATTERN: abstract factory (creational); In Factory pattern, we create object without exposing the creation logic to
 * the client and refer to newly created object using a common interface.
 *
 * PATTERN: singleton (creational) ; only one instance is available.
 */
public class TransactionFactory {

    private static TransactionFactory instance;

    private TransactionFactory(){}

    public static TransactionFactory getInstance(){
        if(instance == null){
            instance = new TransactionFactory();
        }
        return instance;
    }

    public Transaction createLoanTransaction(float loanAmount){

        return new COLILoanTransaction(loanAmount);
    }

    public Transaction createDepositTransaction(float depositAmount){

        return new COLIDepositTransaction(depositAmount);

    }

}
