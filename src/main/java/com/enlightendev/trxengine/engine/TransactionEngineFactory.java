package com.enlightendev.trxengine.engine;

import com.enlightendev.trxengine.engine.impl.COLITransactionEngine;
import com.enlightendev.trxengine.policy.IPolicyContext;

/**
 *
 */
public class TransactionEngineFactory {

    public static ITransactionEngine getTransactionEngine(String name, IPolicyContext policyContext){

        if(name.equalsIgnoreCase("COLI")){
            return new COLITransactionEngine(policyContext);
        }

        return null;
    }
}
