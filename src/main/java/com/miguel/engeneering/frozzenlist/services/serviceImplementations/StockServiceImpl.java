package com.miguel.engeneering.frozzenlist.services.serviceImplementations;

import com.miguel.engeneering.frozzenlist.models.Stock;
import com.miguel.engeneering.frozzenlist.repositories.StockRepository;
import com.miguel.engeneering.frozzenlist.services.StockService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StockServiceImpl implements StockService {

    StockRepository stockRepository;

    @Override
    public Stock saveStock(Stock stock) {
        return this.stockRepository.save(stock);
    }

    @Override
    public List<Stock> saveStocks(List<Stock> stocks) {
        List<Stock>stockList = new ArrayList<>();
        stocks.forEach(stock -> stockList.add(this.saveStock(stock)));
        return stockList;
    }

    @Override
    public Stock findStockByID(Long id) {
        return this.stockRepository.findById(id).orElse(null);
    }

    @Override
    public List<Stock> findAllByID(List<Long> ids) {
        List<Stock>stockList = new ArrayList<>();
        ids.forEach(id -> stockList.add(this.findStockByID(id)));
        return stockList;
    }

    @Override
    public boolean deleteById(Long id) {
        if(this.stockRepository.existsById(id)){
            this.stockRepository.deleteById(id);
            return  true;
        }
        return false;
    }

    @Override
    public void deleteAll(List<Long> ids) {
        stockRepository.deleteAllById(ids);
    }
}
