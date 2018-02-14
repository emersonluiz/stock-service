package br.com.controlunion.stock.dto;

import br.com.controlunion.stock.model.Product;
import br.com.controlunion.stock.model.Size;

public class StockDto {

    private Product product;

    private Long quantity;

    private Size size;

    public StockDto() {}
    
    public StockDto(Product product, Long quantity, Size size) {
        this.product = product;
        this.quantity = quantity;
        this.size = size;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

}
