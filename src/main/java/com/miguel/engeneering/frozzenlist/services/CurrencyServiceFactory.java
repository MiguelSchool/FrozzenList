package com.miguel.engeneering.frozzenlist.services;

import com.miguel.engeneering.frozzenlist.models.Currency;

public class CurrencyServiceFactory {
    public static Currency getCurrency(CurrencyProvider provider){
                return provider.getCurrency();
    }
}
