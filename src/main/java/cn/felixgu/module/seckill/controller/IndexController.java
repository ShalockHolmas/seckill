package cn.felixgu.module.seckill.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class IndexController {

    @RequestMapping(value = "/test")
    @ResponseBody
    public Object index() {
        HashMap<String, String> hash= new HashMap<String, String>(1);
        hash.put("test","test");
        return hash;
    }

    @RequestMapping(value = "/")
    public Object test() {
        return new ArrayList<String>().add("asdtest");
    }
}
