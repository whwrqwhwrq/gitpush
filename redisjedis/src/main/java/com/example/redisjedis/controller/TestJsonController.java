package com.example.redisjedis.controller;

import com.example.redisjedis.bean.Player;
import com.example.redisjedis.response.Response;
import com.example.redisjedis.service.TestService;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @Author:wrq
 * @Date:2020/12/7 17:35
 */
@RestController
@RequestMapping("/wrqTest")
public class TestJsonController {
    @Autowired
    private TestService testService;

    @GetMapping("/testJsonArray/{number}")
    public Response testJsonArray(@PathVariable("number") Integer n) {
        List<TestService.NameCls> nameCls = testService.testJSONArray();
        System.out.println(n);
        return Response.buildSuccessResponse("返回数据", nameCls);
    }

    @GetMapping("/testParamObject")
    public Response testParamObject(Player player) {
        System.out.println(player.getName());
        System.out.println(player.getGender());
        System.out.println(player);
        return Response.buildSuccessResponse("返Hui ", player);
    }

    @PostMapping("/testPostRequest")
    public Response testPostRequest(@RequestBody Player player) {
        System.out.println(player.getName());
        System.out.println(player.getGender());
        System.out.println(player);
        player.setName("wrq");
        player.setGender("male");
        return Response.buildSuccessResponse("返Hui ", player);
    }

    @GetMapping("/testGoogleCollect")
    public Response testGoogleCollect() {
        HashMap<String, Object> map = Maps.newHashMapWithExpectedSize(2);
        map.put("key1", "value1");
        map.put("key2", "value2");
        return Response.buildSuccessResponse("返回map", map);
    }

}
