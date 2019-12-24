public class Demo {
    private static StringBuffer s1 = new StringBuffer();
    private static StringBuffer s2 = new StringBuffer();

    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                synchronized (s1) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    s1.append("a");
                    s2.append("1");
                    synchronized (s2){
                        s1.append("b");
                        s2.append("2");
                    }
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s2) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    s1.append("c");
                    s2.append("3");

                    synchronized (s1){
                        s1.append("d");
                        s2.append("4");
                    }
                }
            }
        }).start();
        System.out.println("s1:"+s1);
        System.out.println("s2:"+s2);
    }
}
