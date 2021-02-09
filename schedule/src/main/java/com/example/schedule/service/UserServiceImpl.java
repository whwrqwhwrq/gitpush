package com.example.schedule.service;

import org.springframework.stereotype.Service;

/**
 * @Author:wrq
 * @Date:2020/11/16 14:51
 */
@Service
public class UserServiceImpl implements IUserService{
    @Override
    public void addUser() {
        System.out.println("新添加了一个用户");
    }
}
