package com.miguel.engeneering.frozzenlist.services.serviceImplementations;

import com.miguel.engeneering.frozzenlist.models.Currency;
import com.miguel.engeneering.frozzenlist.repositories.CurrencyRepository;
import com.miguel.engeneering.frozzenlist.services.CurrencyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private CurrencyRepository currencyRepository;

    @Override
    public Currency saveCurrency(Currency currency) {
        return this.currencyRepository.save(currency);
    }

    @Override
    public List<Currency> saveCurrencies(List<Currency> list) {
        list.forEach(this::saveCurrency);
        return list;
    }

    @Override
    public Currency findCurrencyById(Long id) {
        return this.currencyRepository.findById(id).orElse(null);
    }

    @Override
    public List<Currency> findCurrenciesById(List<Long> ids) {
        List<Currency>currencies = new ArrayList<>();
        ids.forEach(id-> currencies.add(this.findCurrencyById(id)));
        return currencies;
    }

    @Override
    public boolean deleteById(Long id) {
        if(this.currencyRepository.existsById(id)) {
            this.currencyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void deleteAll(List<Long> ids) {
        ids.forEach(this::deleteById);
    }
}
