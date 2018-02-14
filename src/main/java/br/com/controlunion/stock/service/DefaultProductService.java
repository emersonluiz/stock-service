package br.com.controlunion.stock.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.controlunion.stock.model.Product;
import br.com.controlunion.stock.repository.ProductRepository;

@Named
public class DefaultProductService implements ProductService {

    @Inject
    ProductRepository productRepository;

    @Override
    public List<Product> findAll(Integer productCategoryId) {
        if(productCategoryId != null && productCategoryId != 0) {
            return productRepository.findByEnableAndProductCategoryId(true, productCategoryId);
        }
        return productRepository.findByEnable(true);
    }

}
