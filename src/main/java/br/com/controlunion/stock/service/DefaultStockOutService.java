package br.com.controlunion.stock.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.controlunion.stock.dto.StockDto;
import br.com.controlunion.stock.model.Size;
import br.com.controlunion.stock.model.StockOut;
import br.com.controlunion.stock.repository.StockOutRepository;

@Named
public class DefaultStockOutService implements StockOutService {

    @Inject
    StockOutRepository stockOutRepository;
    @Inject
    StockService stockService;

    @Override
    public void create(StockOut stockOut) {
        verifyStock(stockOut.getProduct().getId(), stockOut.getQuantity(), stockOut.getSize());
        stockOutRepository.save(stockOut);
    }

    @Override
    public StockOut findOne(int stockOutId) {
        return stockOutRepository.findOne(stockOutId);
    }

    @Override
    public void update(int stockOutId, StockOut stockOut) {
        findOne(stockOutId);
        stockOut.setId(stockOutId);
        stockOutRepository.save(stockOut);
    }

    @Override
    public void delete(int stockOutId) {
        findOne(stockOutId);
        stockOutRepository.delete(stockOutId);
    }

    @Override
    public Page<StockOut> findAll(Integer productCategoryId, Integer productId, Pageable pageable) {
        Page<StockOut> stock = null;

        if(productCategoryId  != null && productId != null) {
            stock = stockOutRepository.findByProductIdAndProductProductCategoryId(productId, productCategoryId, pageable);
        } else {
            if(productCategoryId == null && productId == null) {
                stock = stockOutRepository.findAll(pageable);
            }

            if(productId != null) {
               stock = stockOutRepository.findByProductId(productId, pageable);
            }

            if(productCategoryId != null) {
               stock = stockOutRepository.findByProductProductCategoryId(productCategoryId, pageable);
            }
        }
        return stock;
    }

    @Override
    public Page<StockOut> findByEmployee(Integer employeeId, Integer productCategoryId, Pageable pageable) {
        if(productCategoryId != null && productCategoryId != 0) {
            return stockOutRepository.findByEmployeeIdAndProductProductCategoryIdOrderByDateOutDesc(employeeId, productCategoryId, pageable);
        }
        return stockOutRepository.findByEmployeeIdAndProductProductCategoryIdNotOrderByDateOutDesc(employeeId, 1, pageable);
    }

    private void verifyStock(int productId, long quantityOut, Size size) {
        List<StockDto> stock = stockService.findByProduct(productId);
        if(stock == null) {
            
        }
        boolean ver = false;
        for (StockDto stockDto : stock) {
            if(size != null) {
                if(stockDto.getSize() != null) {
                    if(stockDto.getProduct().getId() == productId && stockDto.getSize().getId() == size.getId()) {
                        if(stockDto.getQuantity() < quantityOut) {
                            ver = true;
                            break;
                        }
                    }
                }
            } else {
                if(stockDto.getSize() == null) {
                    if(stockDto.getProduct().getId() == productId) {
                        if(stockDto.getQuantity() < quantityOut) {
                            ver = true;
                            break;
                        }
                    }
                }
            }
        }
        if(!ver) {
            
        }
    }

}
