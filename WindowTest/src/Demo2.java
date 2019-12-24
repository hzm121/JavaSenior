
class TicketWindow implements Runnable {
    private static int tickets = 100;

    public void sell() {
        if (tickets>0){
            System.out.println("窗口:" + Thread.currentThread().getName() + "票号:" + tickets);
            tickets--;
        }
    }

    @Override
    public void run() {
        while (true){
            sell();
        }
    }
}

public class Demo2 {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new TicketWindow());
        thread1.setName("窗口1");
        thread1.start();
        Thread thread2 = new Thread(new TicketWindow());
        thread2.setName("窗口2");
        thread2.start();
        Thread thread3 = new Thread(new TicketWindow());
        thread3.setName("窗口3");
        thread3.start();
    }
}
