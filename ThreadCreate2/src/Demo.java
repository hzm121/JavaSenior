/**
 *创建多线程的方式二：实现Runnable接口
 *1.创建一个实现Runnable接口的类
 *2.实现类实现Runnable接口中的run方法
 *3.创建Thread类并将实现类当作参数传递进去
 *4.调用Thread实例对象的start方法
 */
public class Demo implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}
class Test{
    public static void main(String[] args) {
        Demo demo = new Demo();
        Thread thread = new Thread(demo);
        thread.start();
    }
}
