package com.tiiaan.tbm.metaj.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author tiiaan
 * @since 2023-02-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("name")
    private String name;

    @TableField("pwd")
    private String pwd;

    @TableField("phone")
    private String phone;

    @TableField("email")
    private String email;

    @TableField("avatar")
    private String avatar;

    @TableField("dept")
    private String dept;

    @TableField("role")
    private String role;

    @TableField("level")
    private Integer level;


}
