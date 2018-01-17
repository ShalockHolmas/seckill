package cn.felixgu.module.seckill.controller;

import cn.felixgu.module.seckill.entity.UserEntity;
import cn.felixgu.module.seckill.service.UserService;
import cn.felixgu.module.seckill.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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

    @Autowired
    RedisUtil redisHandle;

    @RequestMapping(value = "/test")
    @ResponseBody
    public Object index() {
        HashMap<String, String> hash= new HashMap<String, String>(1);
        hash.put("test","test");
        return hash;
    }

    @RequestMapping(value = "/")
    public Object test() {

        redisHandle.set("asd","111");
        System.out.println(redisHandle.get("asd"));
        HashMap<String, UserEntity> map = new HashMap<>();
        UserEntity userEntity = new UserEntity();
        userEntity.setImageId(222);
        userEntity.setId(112);
        map.put("test",userEntity);
        redisHandle.hmset("test",map,10);


        map = new HashMap<>();
        map = (HashMap<String, UserEntity>) redisHandle.hmget("test");
        System.out.println(map.get("test").getId());



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
