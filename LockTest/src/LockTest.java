import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题方式三:Lock锁-------JDK5.0新增
 */
class Window implements Runnable {
    private int tickets = 100;
    //1.实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                //2.调用锁定方法lock()
                lock.lock();
                if (tickets > 0) {
                    System.out.println("窗口:" + Thread.currentThread().getName() + "票号:" + tickets);
                    tickets--;
                } else {
                    break;
                }
            } finally {
                //3. 解锁线程
                lock.unlock();
            }
        }
    }


}

public class LockTest {


    public static void main(String[] args) {
        Window window = new Window();
        Thread thread1 = new Thread(window);
        Thread thread2 = new Thread(window);
        Thread thread3 = new Thread(window);

        thread1.setName("一");
        thread2.setName("二");
        thread3.setName("三");

        thread1.start();
        thread2.start();
        thread3.start();
    }

}
