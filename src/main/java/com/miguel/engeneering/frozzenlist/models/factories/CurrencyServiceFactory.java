package com.miguel.engeneering.frozzenlist.models.factories;

import com.miguel.engeneering.frozzenlist.models.Currency;
import com.miguel.engeneering.frozzenlist.models.factories.strategies.CurrencyProvider;

public class CurrencyServiceFactory {
    public static Currency getCurrency(CurrencyProvider provider){
                return provider.getCurrency();
    }
}
