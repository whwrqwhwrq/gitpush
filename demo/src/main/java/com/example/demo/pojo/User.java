package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class User {
    @TableId(type = IdType.AUTO) //主键自增策略
    //@TableId(type = IdType.NONE) //未设置主键策略
    //@TableId(type = IdType.INPUT) //手动输入
    //@TableId(type = IdType.ID_WORKER) //以前默认，现在过时
    //@TableId(type = IdType.UUID) //全局唯一id
    private Long id;
    private String name;
    private String gender;
    private Integer age;
    private Integer roleId;
    private String password;
    @Version
    private Integer version;
    @TableLogic
    private Integer deleteid;

}
