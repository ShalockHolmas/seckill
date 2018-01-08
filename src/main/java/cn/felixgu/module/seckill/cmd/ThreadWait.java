package cn.felixgu.module.seckill.cmd;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadWait implements Callable{

    private volatile static String no = "";
    private static AtomicInteger at = new AtomicInteger(0);

    public void increate(){
        at.getAndIncrement();
        synchronized (no) {
            no = no + at.get();
        }
    }

    public String getNo() {
        return no;
    }

    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 10; i ++) {
            increate();
            System.out.println(no);

                System.out.println("this is " + i);

                while (at.get() == 1) {
                    System.out.println("exception before");
                    no.wait();
                    System.out.println("exception after");
                }
                //Thread.currentThread().wait(100);


        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executors = Executors.newCachedThreadPool();
        executors.submit(new ThreadWait());
        executors.submit(new ThreadWait());
        executors.submit(new ThreadWait());
        executors.submit(new ThreadWait());
        executors.submit(new ThreadWait());

    }
}
