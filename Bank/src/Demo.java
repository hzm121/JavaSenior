import java.util.concurrent.locks.ReentrantLock;

class Account {
    private double balance;

    public double addMoney(double money) {
        this.balance += money;
        return balance;
    }
}

class Customer extends Thread {

    private Account account;
    private static ReentrantLock lock = new ReentrantLock();

    public Customer(Account acc) {
        this.account = acc;
    }

    public void deposit(double money) {
        try {
            lock.lock();
            double balance = account.addMoney(money);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "存入" + money + "元，卡内余额：" + balance);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            deposit(1000);
        }
    }
}

public class Demo {
    public static void main(String[] args) {
        Account account = new Account();
        Customer customer1 = new Customer(account);
        Customer customer2 = new Customer(account);

        customer1.setName("老公");
        customer2.setName("老婆");

        customer1.start();
        customer2.start();
    }
}
