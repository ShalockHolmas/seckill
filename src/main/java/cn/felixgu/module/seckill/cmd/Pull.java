package cn.felixgu.module.seckill.cmd;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Pull implements Runnable {

    BlockingQueue<Integer> pool;

    Integer product = 0;

    public Pull(BlockingQueue<Integer> pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        while (true) {
            try {
                pool.put(product);
                System.out.println("add:" + product);
                product++;
            } catch (InterruptedException e) {
                System.out.println("add failed");
                e.printStackTrace();
            }

            if (product == 20){
                break;
            }

        }
    }
}
