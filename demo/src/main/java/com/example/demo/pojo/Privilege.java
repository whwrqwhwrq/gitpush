package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class Privilege {
    private Long priId;
    private String priName;
    private String roleId;
    @Version
    private Integer version;
    @TableLogic
    private Integer deleteid;

}
