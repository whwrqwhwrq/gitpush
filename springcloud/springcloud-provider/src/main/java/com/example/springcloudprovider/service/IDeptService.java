package com.example.springcloudprovider.service;

import com.example.springcloudapi.beans.Dept;

import java.util.List;

/**
 * @Author:wrq
 * @Date:2020/10/30 15:07
 */
public interface IDeptService {

    Dept selectOne(Long deptno);

    List<Dept> selectAll();

    Integer add(Dept dept);

    Integer delete(Long deptno);

}
