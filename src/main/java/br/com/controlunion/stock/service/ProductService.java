package br.com.controlunion.stock.service;

import java.util.List;

import br.com.controlunion.stock.model.Product;

public interface ProductService {

	List<Product> findAll(Integer productCategoryId);
}
