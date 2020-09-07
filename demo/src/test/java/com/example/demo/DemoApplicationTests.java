package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.mapper.PrivilegeMapper;
import com.example.demo.mapper.RoleMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.Role;
import com.example.demo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PrivilegeMapper privilegeMapper;
    @Test
    void contextLoads() {
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);

    }

    @Test
    public void testInsert() {
//        Role role = new Role();
//        role.setRole_name("用户");
//        role.setPri_id(1);
//        int i = roleMapper.insert(role);
//        System.out.println(i);
        User user1 = new User();
        user1.setName("Jedar0k");
        user1.setGender("男");
        user1.setAge(23);
        user1.setRoleId(1);
        user1.setPassword("123456");

        userMapper.insert(user1);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(1L);
        user.setPassword("ww123");//通过条件自动拼接sql
        userMapper.updateById(user); //参数是一个 对象
    }

    @Test
    public void testOptimisticLocker() {
        User user = userMapper.selectById(1L);
        user.setAge(23);
        user.setPassword("123");
        userMapper.updateById(user);
    }
    @Test
    public void testOptimisticLocker2() { //测试失败场景，多线程下
        //线程1
        User user1 = userMapper.selectById(1L);
        user1.setAge(24);
        user1.setPassword("123");
        //模拟线程2 插队操作
        User user2 = userMapper.selectById(1L);
        user2.setAge(25);
        user2.setPassword("321");
        userMapper.updateById(user2); //抢先更新

        userMapper.updateById(user1); //执行后并没生效
    }

    @Test
    //测试查询
    public void testSelect() {
        User user = userMapper.selectById(2);
        System.out.println(user);
    }

    //批量查询
    @Test
    public void testSelect2() {
        List<Long> longs = new ArrayList<>();
        longs.add(1L);
        longs.add(2L);
        longs.add(3L);
        List<User> users = userMapper.selectBatchIds(longs);
        users.forEach(System.out::println);
    }
    //条件查询map
    @Test
    public void testSelect3() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "a");
        List<User> users = userMapper.selectByMap(map);
        System.out.println(users.get(0));

        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("password", "123456");
        map1.put("gender", "男");
        List<User> users1 = userMapper.selectByMap(map1);
        users1.forEach(System.out::println);

    }

    //测试分页查询
    @Test
    public void pageLimit() {
        Page<User> page = new Page<User>(2,5);//进入源码看
        userMapper.selectPage(page, null);
        page.getRecords().forEach(System.out::println);
        System.out.println(page.getTotal());
    }

    //测试删除
    @Test
    public void delete() {
        //根据id删除记录
        //userMapper.deleteById();
        //userMapper.deleteBatchIds();批量删除
        //userMapper.deleteByMap();根据条件删除
        int i = userMapper.deleteById(2L);
        System.out.println(i);
    }

    //逻辑删除(没有真正消除，而是用一个字段标明)
    @Test
    public void logicDelete() {
        int i = userMapper.deleteById(1L);
        System.out.println(i);
    }
    @Test
    public void selectAll() {
        List<Role> roles = roleMapper.selectList(null);
        roles.forEach(System.out::println);
    }

    //wrapper条件
    @Test
    void testWrapper() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age", 22);
        userMapper.selectList(queryWrapper).forEach(System.out::println);
    }
    @Test
    void testWrapper1() {//查询一个数据
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", "a");
        System.out.println(userMapper.selectOne(queryWrapper));
    }
}
