package com.example.redisjedis.controller;

import com.example.redisjedis.bean.Player;
import com.example.redisjedis.response.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:wrq
 * @Date:2021/1/8 17:27
 */
@RestController
public class PlayerController {
    @GetMapping("/fillFields/{name}/{gender}")
    public Response test(@PathVariable String name, @PathVariable String gender) {
        Player player = new Player();
        player.setName(name);
        player.setGender(gender);
        return Response.buildSuccessResponse("iden", player);
    }


    @GetMapping("/fillFields0")
    public Response test0(String name, String gender) {
        Player player = new Player();
        player.setName(name);
        player.setGender(gender);
        return Response.buildSuccessResponse("iden", player);
    }


}
