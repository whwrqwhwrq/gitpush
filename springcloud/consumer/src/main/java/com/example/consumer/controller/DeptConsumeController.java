package com.example.consumer.controller;

import com.example.consumer.constants.UrlConstants;
import com.example.springcloudapi.beans.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * @Author:wrq
 * @Date:2020/10/30 15:46
 */
@RestController
@RequestMapping("/dept")
public class DeptConsumeController {

    Dept dept;
    //通过rest请求
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/get/{deptno}")
    public Dept getByDeptno(@PathVariable("deptno") Long deptno) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(UrlConstants.REST_URL_PREFIX);
        stringBuilder.append("/dept/get/");
        stringBuilder.append(deptno);
        try {
            dept = restTemplate.getForObject(new URI(stringBuilder.toString()),
                    Dept.class);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return dept;
    }

    @GetMapping("consumer/getAll")
    public List<Dept> getAll() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(UrlConstants.REST_URL_PREFIX);
        stringBuilder.append("/dept/getAll");
        List list = restTemplate.getForObject(stringBuilder.toString(), List.class, (Object) null);
        return list;
    }

    @PostMapping("/add")
    public String add(@RequestBody Dept dept) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(UrlConstants.REST_URL_PREFIX);
        stringBuilder.append("/dept/add");
        URI uri = null;
        try {
            uri = new URI(stringBuilder.toString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return restTemplate.postForObject(uri, dept, String.class);
    }
}
