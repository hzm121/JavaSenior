import java.util.concurrent.*;

class NumberThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            System.out.println(i);
            sum+=i;
        }
        return sum;
    }
}

public class Demo1 {
    public static void main(String[] args) {
        ThreadPoolExecutor s = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new NumberThread());
        s.submit(futureTask);
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
