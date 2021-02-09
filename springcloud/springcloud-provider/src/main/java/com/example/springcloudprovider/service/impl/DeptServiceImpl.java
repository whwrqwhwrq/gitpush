package com.example.springcloudprovider.service.impl;

import com.example.springcloudapi.beans.Dept;
import com.example.springcloudprovider.mapper.DeptMapper;
import com.example.springcloudprovider.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author:wrq
 * @Date:2020/10/30 15:08
 */
@Component
public class DeptServiceImpl implements IDeptService {

    @Autowired
    DeptMapper deptMapper;

    @Override
    public Dept selectOne(Long deptno) {
        return deptMapper.selectOne(deptno);
    }

    @Override
    public List<Dept> selectAll() {
        return deptMapper.selectAll();
    }

    @Override
    public Integer add(Dept dept) {
        return deptMapper.add(dept);
    }

    @Override
    public Integer delete(Long deptno) {
        return deptMapper.delete(deptno);
    }
}
