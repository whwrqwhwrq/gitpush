package com.example.demo.shiroConfig;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //设置拦截
        Map<String, String> map = new LinkedHashMap<>();
        map.put("/root/toAllmessage", "perms[seeAll]");
        map.put("/normal/toSee", "perms[seeOwn]");
        map.put("/normal/toUpdate", "perms[updateOwn]");
        map.put("/root/*","authc");
        map.put("/normal/*","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        shiroFilterFactoryBean.setLoginUrl("/toLogin");
        shiroFilterFactoryBean.setUnauthorizedUrl("/toUnauthorized");
        return shiroFilterFactoryBean;
    }
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(userRealm);
        return defaultWebSecurityManager;
    }

    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }
}
