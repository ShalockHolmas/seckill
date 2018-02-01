package cn.felixgu.module.seckill.cmd;

import java.util.concurrent.*;

public class MyThreadYield implements Runnable{


    private Thread t;
    private int status;


    @Override
    public void run() {
        for (int i = 10; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + ":priority-" + Thread.currentThread().getPriority() + "-------" + i);

            if (i == 15) {
                Thread.yield();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyThreadYield());
        thread.setName("first");

        Thread thread1 = new Thread(new MyThreadYield());
        thread1.setName("second");

        thread.start();
        thread1.start();

    }

}
