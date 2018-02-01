package cn.felixgu.module.seckill.cmd;

import java.util.concurrent.*;

public class InterruptByGet implements Callable{
    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 20; i++) {
            System.out.println(i);
            Thread.sleep(200);
        }
        return "success";
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        Future<String> future = service.submit(new InterruptByGet());
        service.shutdown();
        try {
            future.get(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            System.out.println("time out -->");
            future.cancel(true);
            System.out.println("interrupt thread -->");
            e.printStackTrace();
        }

    }
}
