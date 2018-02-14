package br.com.controlunion.stock.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.controlunion.stock.dto.StockDto;
import br.com.controlunion.stock.model.Product;
import br.com.controlunion.stock.repository.ProductRepository;
import br.com.controlunion.stock.repository.StockInRepository;
import br.com.controlunion.stock.repository.StockOutRepository;

@Named
public class DefaultStockService implements StockService {

    @Inject
    StockInRepository stockInRepository;

    @Inject
    StockOutRepository stockOutRepository;

    @Inject
    ProductRepository productRepository;

    @Override
    public List<StockDto> findByProduct(int productId) {
        Product product = productRepository.findOne(productId);
        List<StockDto> listIn = stockInRepository.findSum(productId);
        List<StockDto> listOut = stockOutRepository.findSum(productId);

        List<StockDto> list = new ArrayList<StockDto>();

        for (StockDto stockDtoIn : listIn) {
            if(product.getId() == stockDtoIn.getProduct().getId()) {
                Long quantityIn = stockDtoIn.getQuantity();
                if(quantityIn == null) {
                    quantityIn = 0l;
                }
                Long quantityOut = 0l;

                for (StockDto stockDtoOut : listOut) {
                    if(stockDtoIn.getSize() != null) {
                        if(stockDtoOut.getSize() != null) {
                            if(stockDtoIn.getProduct().getId() == stockDtoOut.getProduct().getId() && stockDtoIn.getSize().getId() == stockDtoOut.getSize().getId()) {
                                quantityOut = stockDtoOut.getQuantity();
                                if(quantityOut == null) {
                                    quantityOut = 0l;
                                }
                                break;
                            }
                        }
                    } else {
                        if(stockDtoIn.getProduct().getId() == stockDtoOut.getProduct().getId()) {
                            if(stockDtoOut.getSize() == null) {
                                quantityOut = stockDtoOut.getQuantity();
                                if(quantityOut == null) {
                                    quantityOut = 0l;
                                }
                                break;
                            }
                        }
                    }
                }
                list.add(new StockDto(product, (quantityIn - quantityOut), stockDtoIn.getSize()));
            }
        }

        if(list.size() == 0) {
            list.add(new StockDto(product, 0l, null));
        }

        return list;
    }

    @Override
    public List<StockDto> findAll() {
        List<Product> products = productRepository.findByEnable(true);
        List<StockDto> listIn = stockInRepository.findAllSum();
        List<StockDto> listOut = stockOutRepository.findAllSum();

        List<StockDto> list = new ArrayList<StockDto>();

        for (Product product : products) {
            for (StockDto stockDtoIn : listIn) {
                if(product.getId() == stockDtoIn.getProduct().getId()) {
                    Long quantityIn = stockDtoIn.getQuantity();
                    if(quantityIn == null) {
                        quantityIn = 0l;
                    }
                    Long quantityOut = 0l;

                    for (StockDto stockDtoOut : listOut) {
                        if(stockDtoIn.getSize() != null) {
                            if(stockDtoOut.getSize() != null) {
                                if(stockDtoIn.getProduct().getId() == stockDtoOut.getProduct().getId() && stockDtoIn.getSize().getId() == stockDtoOut.getSize().getId()) {
                                    quantityOut = stockDtoOut.getQuantity();
                                    if(quantityOut == null) {
                                        quantityOut = 0l;
                                    }
                                    break;
                                }
                            }
                        } else {
                            if(stockDtoIn.getProduct().getId() == stockDtoOut.getProduct().getId()) {
                                if(stockDtoOut.getSize() == null) {
                                    quantityOut = stockDtoOut.getQuantity();
                                    if(quantityOut == null) {
                                        quantityOut = 0l;
                                    }
                                    break;
                                }
                            }
                        }
                    }
                    long qt = (quantityIn - quantityOut);
                    if(qt > 0) {
                        list.add(new StockDto(product, qt, stockDtoIn.getSize()));
                    }
                }
            }
        }

        return list;
    }

}
