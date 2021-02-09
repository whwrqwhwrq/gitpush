package com.example.redisjedis.controller;

import com.example.redisjedis.response.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.Random;

/**
 * @Author:wrq
 * @Date:2020/12/4 16:26
 */
@RestController
@RequestMapping("/redis")
public class RedisOpController {
    @Value("${host}")
    private String host;
    @Value("${port}")
    private Integer port;

    private static final String HASH_SET_ID = "HASH_SET_ID";

    @GetMapping("/test")
    public Response test(String p) {
        return Response.buildSuccessResponse("测试",p);
    }
    @GetMapping("/save")
    public Response save(@RequestParam String str) {
        double pow = 0;
        try {
            pow = Math.pow(Integer.parseInt(str), 2);
        } catch (NumberFormatException e) {
            return Response.buildFailureResponse("数据越界");
        }

        Jedis jedis = new Jedis(host, port);
        int redisSetKey = (int) pow;
        jedis.hset(HASH_SET_ID, String.valueOf(redisSetKey), generateStr(redisSetKey));
        return Response.buildSuccessResponse("写入redis成功", str);
    }
    private String generateStr(Integer integer) {
        Random random = new Random();
        int randomInteger = random.nextInt(integer);
        char[] chars = Character.toChars(randomInteger);
        StringBuilder stringBuilder = new StringBuilder();
        for (char aChar : chars) {
            stringBuilder.append(aChar);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        RedisOpController redisOpController = new RedisOpController();
        String s = redisOpController.generateStr(2323);
        System.out.println(s);
    }
}
