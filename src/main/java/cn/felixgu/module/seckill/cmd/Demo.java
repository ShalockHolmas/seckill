package cn.felixgu.module.seckill.cmd;

import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.*;

public class Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ThreadFactory factory = new ThreadFactory() {
            String name = "test:";
            int no = 0;
            @Override
            public Thread newThread(Runnable r) {
                no ++;
                Thread thread = new Thread(r);
                thread.setName(name + no);
                thread.setDaemon(false);
                return thread;
            }
        };

        DemoTest demoTest = new DemoTest();
        Executor service = new ThreadPoolExecutor(
                1,
                Integer.MAX_VALUE,1,
                TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(),
                factory);

        service.execute(demoTest);
        service.execute(demoTest);
        service.execute(demoTest);
        service.execute(demoTest);

//        new Thread(new DemoTest()).start();

    }


}
