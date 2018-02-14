package br.com.controlunion.stock.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.controlunion.stock.model.StockIn;
import br.com.controlunion.stock.repository.StockInRepository;

@Named
public class DefaultStockInService implements StockInService {

    @Inject
    StockInRepository stockInRepository;

    @Override
    public void create(StockIn stockIn) {
        stockInRepository.save(stockIn);
    }

    @Override
    public StockIn findOne(int stockInId) {
        return stockInRepository.findOne(stockInId);
    }

    @Override
    public void update(int stockInId, StockIn stockIn) {
        findOne(stockInId);
        stockIn.setId(stockInId);
        stockInRepository.save(stockIn);
    }

    @Override
    public void delete(int stockInId) {
        findOne(stockInId);
        stockInRepository.delete(stockInId);
    }

    @Override
    public Page<StockIn> findAll(Integer productCategoryId, Integer productId, Pageable pageable) {
        Page<StockIn> stock = null;

        if(productCategoryId  != null && productId != null) {
            stock = stockInRepository.findByProductIdAndProductProductCategoryId(productId, productCategoryId, pageable);
        } else {
            if(productCategoryId == null && productId == null) {
                stock = stockInRepository.findAll(pageable);
            }

            if(productId != null) {
               stock = stockInRepository.findByProductId(productId, pageable);
            }

            if(productCategoryId != null) {
               stock = stockInRepository.findByProductProductCategoryId(productCategoryId, pageable);
            }
        }
        return stock;
    }

}
