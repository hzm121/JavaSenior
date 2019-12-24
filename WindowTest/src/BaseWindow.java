public class BaseWindow {
    private static int ticket = 100;

    public static void setSum(int sum) {
        BaseWindow.sum = sum;
    }

    public static int getSum() {
        return sum;
    }

    private static int sum = 0;

    public static void setTicket(int ticket) {
        BaseWindow.ticket = ticket;
    }

    public BaseWindow() {
        BaseWindow.ticket = ticket;
    }

    public static int getTicket() {
        return ticket;
    }

    public void sell(){
        if (BaseWindow.ticket <= 0){
            System.out.println(Thread.currentThread().getName()+"票已卖完!");
            return;
        }
        BaseWindow.ticket = ticket-1;
        BaseWindow.sum++;
    }
    public void inform(String msg){
        System.out.println(msg);
    }
    public void printTickets(){
        System.out.println(Thread.currentThread().getName()+":"+BaseWindow.ticket);
    }
}
