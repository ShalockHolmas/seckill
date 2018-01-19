package cn.felixgu.module.seckill.cmd;

public class ExecFlow implements Runnable{

    Thread thread;

    public ExecFlow(Thread thread) {
        this.thread = thread;
    }

    public void setNextThread(Thread thread){
        this.thread = thread;
    }

    @Override
    public void run() {
        for( int i = 5; i <= 10; i++) {
            System.out.println(i + Thread.currentThread().getName());
        }
        if (thread != null) {
            thread.start();
            Thread.yield();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new ExecFlow(new Thread(new ExecFlow(new Thread(new ExecFlow(null))))));
        thread1.start();
    }
}
