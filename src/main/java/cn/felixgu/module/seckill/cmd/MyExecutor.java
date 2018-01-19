package cn.felixgu.module.seckill.cmd;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class MyExecutor {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingDeque<>(10);
        Thread thread = new Thread(new Push(queue));
        Thread thread1 = new Thread(new Pull(queue));
        thread1.start();
        thread.start();
    }
}
