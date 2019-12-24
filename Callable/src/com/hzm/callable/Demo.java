package com.hzm.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class NumberThread implements Callable<Integer>{
    private int sum = 0;
    public int doSum(int end){
        for (int i = 0; i <=end; i++) {
            System.out.println(i);
            sum+=i;
        }
        return sum;
    }
    @Override
    public Integer call() throws Exception {
        return doSum(100);
    }
}
public class Demo {
    public static void main(String[] args) {
        Integer sum = 0;
        NumberThread numberThread = new NumberThread();
        FutureTask<Integer> futureTask = new FutureTask(numberThread);
        new Thread(futureTask).start();
        try {
            sum = futureTask.get();
            System.out.println("值："+sum.toString());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("值："+sum.toString());
    }

}
