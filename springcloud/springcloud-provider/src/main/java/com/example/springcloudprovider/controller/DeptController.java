package com.example.springcloudprovider.controller;

import com.alibaba.fastjson.JSON;
import com.example.springcloudapi.beans.Dept;
import com.example.springcloudprovider.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @Author:wrq
 * @Date:2020/10/30 15:13
 */

@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    IDeptService deptService;

    @PostMapping("/add")
    public Boolean add(@RequestBody Dept dept) {
        Integer add = deptService.add(dept);
        Boolean res = add > 0 ? true : false;
        return res;
    }

    @GetMapping("/get/{deptno}")
    public String get(@PathVariable("deptno") Long deptno) {
        Dept dept = deptService.selectOne(deptno);
        return JSON.toJSONString(dept);
    }

    @GetMapping("/getAll")
    public List<Dept> getAll() {
        List<Dept> depts = deptService.selectAll();
        return depts;
    }

    @GetMapping("/delete")
    public String delete(@PathVariable("deptno") Long deptno) {
        Integer delete = deptService.delete(deptno);
        String str = delete > 0 ? "删除成功" : "删除失败";
        return str;
    }
    @GetMapping("/testMapToJson")
    public String delete() {
        HashMap<String, Object> map = new HashMap<>();

        map.put("qaz", "mpz");
        map.put("123", "mpz");
        map.put("sdf", "mpz");
        map.put("dfg", "mpz");
        map.put("fgh", "mpz");

        return JSON.toJSONString(map);
    }
}
