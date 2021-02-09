package com.example.springcloudprovider.mapper;

import com.example.springcloudapi.beans.Dept;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author:wrq
 * @Date:2020/10/30 14:45
 */
@Component
public interface DeptMapper {

    Dept selectOne(Long deptno);

    List<Dept> selectAll();

    Integer add(Dept dept);

    Integer delete(Long deptno);
}
