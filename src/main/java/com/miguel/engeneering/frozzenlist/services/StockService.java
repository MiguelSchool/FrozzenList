package com.miguel.engeneering.frozzenlist.services;

import com.miguel.engeneering.frozzenlist.models.Stock;

import java.util.List;

public interface StockService {
    public Stock saveStock(Stock stock);
    public List<Stock> saveStocks(List<Stock>stocks);
    public Stock findStockByID(Long id);
    public List<Stock> findAllByID(List<Long>ids);
    public boolean deleteById(Long id);
    public void deleteAll(List<Long>ids);
}
