package com.hzm.Test;

import com.hzm.model.Customer;
import com.hzm.model.Producter;
import com.hzm.model.Shop;

public class Test1 {
    public static void main(String[] args) {
        Shop shop = new Shop("和平商店");
        Customer customer = new Customer(shop);
        Producter producter = new Producter(shop);

        Thread customer1 = new Thread(customer);
        Thread customer2 = new Thread(customer);
        Thread customer3 = new Thread(customer);

        Thread producter1 = new Thread(producter);
        Thread producter2 = new Thread(producter);
        Thread producter3 = new Thread(producter);

        customer1.start();
        customer2.start();
        customer3.start();
        producter1.start();
        producter2.start();
        producter3.start();

    }
}
