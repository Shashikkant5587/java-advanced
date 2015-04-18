package com.enlightendev.trxengine.engine;

import com.enlightendev.trxengine.policy.IPolicyContext;
import com.enlightendev.trxengine.trx.Transaction;

import java.util.List;

/**
 *
 */
public interface ITransactionEngine {

    void setPolicyContext(IPolicyContext policyContext);

    IPolicyContext getPolicyContext();

    String getName();

    void add(Transaction trx);

    void processGiven(List<Transaction> transactions);

    void processAll();

}
