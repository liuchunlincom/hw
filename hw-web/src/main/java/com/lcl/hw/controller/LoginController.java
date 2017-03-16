package com.lcl.hw.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * Created by Rain on 2016/12/30 14:05.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ShardedJedisPool shardedJedisPool;
    @RequestMapping("/toLogin")
    public String toLoginPage(){
        ShardedJedis shardedJedis = shardedJedisPool.getResource();
        shardedJedis.set("url","/login/toLogin");
        logger.info(shardedJedis.get("url")+"======================");
        System.out.println("==++++++++++++++++++++++");
        return "decorator/login";

    }
    @RequestMapping("/toRegister")
    public String toRegisterPage(){
        return "decorator/register";

    }
}
