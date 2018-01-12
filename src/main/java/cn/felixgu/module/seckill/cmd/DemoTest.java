package cn.felixgu.module.seckill.cmd;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DemoTest implements Runnable {


    @Override
    public void run() {
        System.out.println("this is " + Thread.currentThread().getName());
        new ConcurrentHashMap<>();
    }
}
