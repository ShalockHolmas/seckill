package cn.felixgu.module.seckill.cmd;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Push implements Runnable{

    BlockingQueue<Integer> pool;

    public Push(BlockingQueue<Integer> pool) {
        this.pool = pool;
    }

    @Override
    public void run() {

        while(true) {
            try {
                Integer tmp = pool.take();
                System.out.println("take:" + tmp);
            } catch (InterruptedException e) {
                System.out.println("获取失败");
                e.printStackTrace();
            }
        }
    }
}
