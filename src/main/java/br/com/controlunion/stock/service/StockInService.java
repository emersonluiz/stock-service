package br.com.controlunion.stock.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.controlunion.stock.model.StockIn;

public interface StockInService {

    void create(StockIn stockIn);

    StockIn findOne(int stockInId);

    void update(int stockInId, StockIn stockIn);

    void delete(int stockInId);

    Page<StockIn> findAll(Integer productCategoryId, Integer productId, Pageable pageable);
}
