package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.demo.mapper.PrivilegeMapper;
import com.example.demo.mapper.RoleMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.Role;
import com.example.demo.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class RouteController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PrivilegeMapper privilegeMapper;
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping({"/", "/index"})
    public String index() {
        return "index";
    }

    @RequestMapping("/normal/toUpdate")
    public String toUpdate(Model model) {
        String loginUsername = (String) SecurityUtils.getSubject().getSession().getAttribute("loginUsername");
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("name", loginUsername);
        User user = userMapper.selectOne(userQueryWrapper);
        Integer roleId = user.getRoleId();
        QueryWrapper<Role> roleQueryWrapper = new QueryWrapper<>();
        roleQueryWrapper.eq("role_id", roleId);
        Role role = roleMapper.selectOne(roleQueryWrapper);

        model.addAttribute("name", loginUsername);
        model.addAttribute("gender",user.getGender());
        model.addAttribute("age",user.getAge());
        model.addAttribute("password",user.getPassword());
        model.addAttribute("role", role.getRoleName());
        return "normal/update";
    }

    @RequestMapping("/update")
    public String update(String name, String gender, Integer age, String password) {
        User user = new User();
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("name", name).set("gender",gender).set("age",age).set("password",password);
        userMapper.update(user,userUpdateWrapper);
        return "updateSuccess";
        }
    @RequestMapping("/normal/toSee")
    public String toSee(Model model) {
        String loginUsername = (String) SecurityUtils.getSubject().getSession().getAttribute("loginUsername");
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("name", loginUsername);
        User user = userMapper.selectOne(userQueryWrapper);
        Integer roleId = user.getRoleId();
        QueryWrapper<Role> roleQueryWrapper = new QueryWrapper<>();
        roleQueryWrapper.eq("role_id", roleId);
        Role role = roleMapper.selectOne(roleQueryWrapper);

        model.addAttribute("name", loginUsername);
        model.addAttribute("gender",user.getGender());
        model.addAttribute("age",user.getAge());
        model.addAttribute("password",user.getPassword());
        model.addAttribute("role", role.getRoleName());
        return "normal/see";
    }

    @RequestMapping("/root/toAllmessage")
    public String toAllmessage(Model model) {
        List<User> users = userMapper.selectList(null);
        model.addAttribute("users",users);

        return "root/allmessage";
    }

    @GetMapping("/root/toUpdate/{id}")
    public String rootToUpdate(@PathVariable("id")Long id,Model model) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("id", id);
        User user = userMapper.selectOne(userQueryWrapper);
        Integer roleId = user.getRoleId();
        QueryWrapper<Role> roleQueryWrapper = new QueryWrapper<>();
        roleQueryWrapper.eq("role_id", roleId);
        Role role = roleMapper.selectOne(roleQueryWrapper);
        model.addAttribute("id",id);
        model.addAttribute("name", user.getName());
        model.addAttribute("gender",user.getGender());
        model.addAttribute("age",user.getAge());
        model.addAttribute("password",user.getPassword());
        model.addAttribute("role", role.getRoleName());
        model.addAttribute("role_id",roleId);
        return "root/update";
    }

    @RequestMapping("/root/update/{id}")
    public String rootUpdate(@PathVariable("id")String id,String name,String gender,Integer age,String password,Integer role) {
        User user = new User();
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("id",id).set("name", name).set("gender",gender).set("age",age).set("password",password).set("role_id",role);
        userMapper.update(user,userUpdateWrapper);
        return "redirect:/root/toAllmessage";
    }
    @RequestMapping("/root/delete/{id}")
    public String rootDelete(@PathVariable("id")String id) {
        userMapper.deleteById(id);
        return "redirect:/root/toAllmessage";
    }
    @RequestMapping("/toRegister")
    public String toRegister() {
        return "register";
    }

    @RequestMapping("/login")
    public String login(String username, String password, Model model) {
        //获取用户
        Subject subject = SecurityUtils.getSubject();
        if (username.equals("") || password.equals("")||username==null||password==null) {
            model.addAttribute("msg", "用户名和密码不能为空");
            return "login";
        }
        //封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);//执行登录方法

            return "index";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg", "用户名不存在");
            return "login";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "密码错误");
            return "login";

        }
    }

    @RequestMapping("/register")
    public String register(String username, String password, String gender, int age,Model model) {

        //判断是否重复注册
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", username);
        User user1 = userMapper.selectOne(queryWrapper);
        if (user1 == null) {
            User user = new User();
            user.setName(username);
            user.setPassword(password);
            user.setGender(gender);
            user.setAge(age);
            user.setRoleId(1);
            userMapper.insert(user);
            return "registerSuccess";
        }
        model.addAttribute("msg","用户已存在");
        return "register";

    }

    @RequestMapping("/toUnauthorized")
    public String toUnauthorized() {
        return "unauthorized";
    }
    @RequestMapping("/logout")
    public String logout() {
        //拿到当前用户
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/";
    }
}
