package cn.felixgu.module.seckill.controller;

import cn.felixgu.module.seckill.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class IndexController {

    Logger log = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    UserService userService;

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


    @RequestMapping(value = "/transaction")
    public Object transaction() {
        try {
            userService.test();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
