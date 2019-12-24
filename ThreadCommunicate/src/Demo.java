class Number implements Runnable{
    private int number = 1;

    public void print(){
        synchronized (this) {
            notify();
            if (number <= 100){
                System.out.println(Thread.currentThread().getName()+number);
                number++;
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                return;
            }
        }
    }
    @Override
    public void run() {
        while (true){
            print();
        }
    }
}

public class Demo {


    public static void main(String[] args) {
        Number number = new Number();
        Thread th1 = new Thread(number);
        Thread th2 = new Thread(number);
        th1.setName("线程1：");
        th2.setName("线程2：");
        th1.start();
        th2.start();
    }
}
