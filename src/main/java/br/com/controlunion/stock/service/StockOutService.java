package br.com.controlunion.stock.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.controlunion.stock.model.StockOut;

public interface StockOutService {

    void create(StockOut stockOut);

    StockOut findOne(int stockOutId);

    void update(int stockOutId, StockOut stockOut);

    void delete(int stockOutId);

    Page<StockOut> findAll(Integer productCategoryId, Integer productId, Pageable pageable);

    Page<StockOut> findByEmployee(Integer employeeId, Integer productCategoryId, Pageable pageable);
}
