package com.hzm.model;

public class Producter implements Runnable {
    public Producter(Shop shop) {
        this.shop = shop;
    }
    private Shop shop;

    public void product(Shop shop) {
        System.out.println("生产者:" + Thread.currentThread().getName() + "往" + shop.toString() + "供货一个产品");
        shop.importProduct();
    }

    @Override
    public void run() {
            while (true){
                synchronized (this) {
                    notifyAll();
                    if (shop.getProduct()<20){
                        product(shop);
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else{
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
    }
}
