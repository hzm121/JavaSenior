package com.hzm.model;

public class Shop {
    private int product = 10;
    private String name;

    public Shop(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }
    //商品被买
    public void beBuy(){
        product--;
    }
    //进货
    public void importProduct(){
        product++;
    }

    @Override
    public String toString() {
        return name;
    }
}
