package com.miguel.engeneering.frozzenlist.models.factories.strategies;

import com.miguel.engeneering.frozzenlist.models.Currency;
import com.miguel.engeneering.frozzenlist.models.factories.strategies.CurrencyProvider;

public class CurrencyDollar implements CurrencyProvider {

    private final String CURRENCYCODE = "USD";
    private final String name = "Dollar";

    @Override
    public Currency getCurrency() {
        return new Currency(name,CURRENCYCODE);
    }
}
