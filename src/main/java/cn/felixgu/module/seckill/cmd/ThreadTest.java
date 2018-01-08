package cn.felixgu.module.seckill.cmd;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadTest implements Callable {

    private static AtomicInteger no = new AtomicInteger(0);

    public ThreadTest() {
        System.out.println("===");
    }

    @Override
    public String call() throws Exception {
        no.getAndIncrement();
        Thread.currentThread().setName("Thread:" + no.toString());
        for (int i =0; i< 3;i++){
            if (i==3) {
                //Thread.currentThread().wait();
            }
            System.out.println(Thread.currentThread().getName() + " i = " + i);
        }
        return Thread.currentThread().getName();
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        List<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            results.add(service.submit(new ThreadTest()));
        }

        for (Future<String> re :
                results) {
            try {
                System.out.println(re.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
