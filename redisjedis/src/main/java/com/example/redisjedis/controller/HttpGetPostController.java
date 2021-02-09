package com.example.redisjedis.controller;

import com.alibaba.fastjson.JSON;
import com.example.redisjedis.bean.Country;
import com.example.redisjedis.utils.HttpClientUtil;
import com.google.common.collect.Maps;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @Author:wrq
 * @Date:2021/1/8 18:01
 */
@RestController
public class HttpGetPostController {
    private static final String URL = "http://localhost:30001/country/get/all";
    @GetMapping("/getAllCountries")
    public List<Country> getAllCountries() {
        HashMap<String, Object> param = Maps.newLinkedHashMap();
        param.put("pageNum", 1);
        param.put("pageSize", 1000);

        String response = HttpClientUtil.get(URL, param, true);
        return JSON.parseArray(response, Country.class);

    }


    @GetMapping("/getAllCountriesWithoutPage")
    public List<Country> getAllCountriesWithoutPage() {
        String response = HttpClientUtil.get(URL);
        return JSON.parseArray(response, Country.class);
    }


}
