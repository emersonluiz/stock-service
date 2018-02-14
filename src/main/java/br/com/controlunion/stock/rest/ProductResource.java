package br.com.controlunion.stock.rest;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.controlunion.stock.model.Product;
import br.com.controlunion.stock.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductResource {

    @Inject
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Product> findAll(@RequestParam(required = false, value = "productCategoryId") Integer productCategoryId) {
        return productService.findAll(productCategoryId);
    }

}