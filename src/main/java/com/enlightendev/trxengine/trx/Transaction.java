package com.enlightendev.trxengine.trx;

import com.enlightendev.trxengine.policy.IPolicyContext;

/**
 * Interface specifying the minimum contract that must be present in a specific transaction.
 *
 * PATTERN: Strategy;
 *
 * Define a family of algorithms, encapsulate each one, and make them interchangeable. Strategy lets the algorithm vary
 * independently from the clients that use it. Capture the abstraction in an interface, bury implementation details in
 * derived classes.
 *
 * clients (in our case the transaction engine) simply call process transaction and thus are
 * shielded from implementation details of how the trx is processed. Derived classes implement the details of how
 * each trx is handled.
 */
public interface Transaction {

    String TRANSACTION_TYPE_LOAN = "TrxLoan";
    String TRANSACTION_TYPE_DEPOSIT = "TrxDeposit";

    /**
     *
     * @param policyContext the policy this transaction applies to.
     */
    public void processTransaction(IPolicyContext policyContext);

    /**
     *
     * @return
     */
    public String getType();

}
