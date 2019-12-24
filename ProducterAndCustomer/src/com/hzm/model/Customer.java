package com.hzm.model;

public class Customer implements Runnable{
    public Customer(Shop shop) {
        this.shop = shop;
    }

    private Shop shop;

    public void buy(Shop shop){
        System.out.println("顾客："+Thread.currentThread().getName()+"在"+shop.toString()+"购买了一个商品");
        shop.beBuy();
    }
    @Override
    public void run() {
            while(true){
                synchronized (this) {
                    notifyAll();
                    if (shop.getProduct()>0){
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        buy(shop);
                    }else {
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
    }
}
