package com.roncoo.eshop.inventory.model;


public class ProductInventory {

    private Long id;
    private Double value;
    private Long productId;

    public ProductInventory() {
    }

    public ProductInventory(Long id, Double value, Long productId) {
        this.id = id;
        this.value = value;
        this.productId = productId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
