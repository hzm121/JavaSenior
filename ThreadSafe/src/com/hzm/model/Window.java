package com.hzm.model;

public class Window implements Runnable {

    private int tickets = 100;
    Object locker = new Object();
    @Override
    public void run() {
        while (true){
            synchronized(locker){
                if (tickets > 0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"票号:"+tickets);
                    tickets--;
                }
            }
        }
    }
}
