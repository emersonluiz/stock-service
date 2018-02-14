package br.com.controlunion.stock.repository;

import java.util.List;

import javax.inject.Named;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.controlunion.stock.model.Product;

@Named
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByEnable(Boolean enable);

    List<Product> findByEnableAndProductCategoryId(Boolean enable, int productCategoryId);
}
