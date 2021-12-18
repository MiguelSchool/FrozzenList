package com.miguel.engeneering.frozzenlist.services;

import com.miguel.engeneering.frozzenlist.models.Currency;

import java.util.List;

public interface CurrencyService {

    Currency saveCurrency(Currency currency);
    List<Currency>saveCurrencies(List<Currency>list);

    Currency findCurrencyById(Long id);
    List<Currency>findCurrenciesById(List<Long>ids);

    boolean deleteById(Long id);
    void deleteAll(List<Long>ids);
}
