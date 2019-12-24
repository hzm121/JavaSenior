public class Window extends BaseWindow {
    public Window(){
        super();
    }

    @Override
    public void sell() {
        super.sell();
        printTickets();
    }

    public static void main(String[] args) {
        int sum =0;
        Window window1 = new Window();
        new Thread(){
            @Override
            public void run() {
                Window window2 = new Window();
                for (int i = 0; i < 30; i++) {
                    window2.sell();

                }
            }
        }.start();
        for (int i = 0; i < 80; i++) {
            window1.sell();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Window.getSum());

    }
}
