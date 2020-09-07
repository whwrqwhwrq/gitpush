package com.example.demo.shiroConfig;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.mapper.PrivilegeMapper;
import com.example.demo.mapper.RoleMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.Privilege;
import com.example.demo.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PrivilegeMapper privilegeMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了doGetAuthorizationInfo方法");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //拿到当前用户
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        //数据库 里  读取 权限
        Integer roleId = user.getRoleId();
        QueryWrapper<Privilege> privilegeQueryWrapper = new QueryWrapper<>();
        privilegeQueryWrapper.eq("role_id", roleId);
        List<Privilege> privileges = privilegeMapper.selectList(privilegeQueryWrapper);
        //赋予当前用户 应得的 权限
        for (Privilege privilege : privileges) {
            info.addStringPermission(privilege.getPriName());
        }

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", token.getUsername());
        User user = userMapper.selectOne(queryWrapper);
        if (user==null) {
            return null;
        }
        SecurityUtils.getSubject().getSession().setAttribute("loginUser",user);//放到session里
        SecurityUtils.getSubject().getSession().setAttribute("loginUsername",user.getName());//放到session里
        return new SimpleAuthenticationInfo(user, user.getPassword(), "");
    }
}
