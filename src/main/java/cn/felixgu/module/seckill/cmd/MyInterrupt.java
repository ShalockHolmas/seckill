package cn.felixgu.module.seckill.cmd;

public class MyInterrupt implements Runnable{


    private volatile int i = 0;
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {

            System.out.println(i++ + String.valueOf(Thread.currentThread().isInterrupted()));

            try {
                Thread.sleep(100);
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
            if (i == 20) {
                cancel();
            }

        }
    }

    public void cancel(){
        Thread.currentThread().interrupt();
    }

    public static void main(String[] args) {
        new Thread(new MyInterrupt()).start();
    }
}
