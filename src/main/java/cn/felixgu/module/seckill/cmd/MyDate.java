package cn.felixgu.module.seckill.cmd;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class MyDate {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println(date.toString());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:m:ss");
        System.out.println(dateFormat.format(new Date()));
    }
}
