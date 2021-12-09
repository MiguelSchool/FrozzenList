package com.miguel.engeneering.frozzenlist.models.factories.strategies;

import com.miguel.engeneering.frozzenlist.models.Currency;
import com.miguel.engeneering.frozzenlist.models.factories.strategies.CurrencyProvider;

public class CurrencyEuro implements CurrencyProvider {

    private final String CURRENCYCODE = "EUR";
    private final String name = "Euro";

    @Override
    public Currency getCurrency() {
        return new Currency(name,CURRENCYCODE);
    }
}
