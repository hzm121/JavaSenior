package com.hzm.test;

import com.hzm.model.Window;

public class TestThreadSafe {
    public static void main(String[] args) {
        Window w = new Window();
        Thread thread1 = new Thread(w);
        Thread thread2 = new Thread(w);
        Thread thread3 = new Thread(w);

        thread1.setName("窗口一：");
        thread2.setName("窗口二：");
        thread3.setName("窗口三：");

        thread1.start();
        thread2.start();
        thread3.start();
    }


}
