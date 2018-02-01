package cn.felixgu.module.seckill.cmd;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadFactory implements ThreadFactory{

    private AtomicInteger tNo = new AtomicInteger(0);
    private int pNo = 8;
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setName("thread-" + tNo.getAndIncrement() + "=====");
        pNo --;
        t.setPriority(pNo);
        return t;
    }
}
