package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    private Long roleId;
    private String roleName;
    @Version
    private Integer version;
    @TableLogic
    private Integer deleteid;
}
