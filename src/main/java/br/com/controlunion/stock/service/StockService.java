package br.com.controlunion.stock.service;

import java.util.List;

import br.com.controlunion.stock.dto.StockDto;

public interface StockService {

    List<StockDto> findByProduct(int productId);

    List<StockDto> findAll();
}
