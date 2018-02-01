package cn.felixgu.module.seckill.cmd;

import java.math.BigDecimal;
import java.util.ArrayList;

public class OneTimeScript {
    public static void main(String[] args) {
        ArrayList<Object> params = new ArrayList<>();
        params.add("sad");
        params.add(new BigDecimal(1));

        Object[] s = params.toArray(new Object[params.size()]);
        for (Object ss : s
             ) {
            System.out.println(ss);
        }
    }
}
