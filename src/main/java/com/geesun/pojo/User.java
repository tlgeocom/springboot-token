package com.geesun.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "public.user")
public class User implements Serializable {
    @TableId(value = "id", type = IdType.NONE)
    private String id;

    @TableField(value = "username")
    private String username;

    @TableField(value = "password")
    private String password;

    private static final long serialVersionUID = 1L;
}