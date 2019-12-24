package com.hzm.java;

/**
 * 多线程的创建，
 * 方式一：
 * 创建一个继承于Thread类的子类
 * 重写run方法
 * 创建该子类对象
 * 调用该对象的start方法
 */

public class ThreadTest extends Thread {

    private int i;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        ThreadTest thread = new ThreadTest();
        ThreadTest2 threadTest2 = new ThreadTest2();
        thread.start();
        threadTest2.start();
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("匿名子类实现线程"+i);
                }
            }
        }.start();
    }
}
class ThreadTest2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2!=0){
                System.out.println(Thread.currentThread().getName()+":"+ i);
            }
        }
    }
}
