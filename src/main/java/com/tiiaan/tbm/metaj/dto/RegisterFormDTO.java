package com.tiiaan.tbm.metaj.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tiiaan Email:tiiaan.w@gmail.com
 * @version 0.0
 * description
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterFormDTO {

    private String name;
    private String pwd;
    private String phone;
    private String email;
    private String avatar;
    private String dept;
    private String role;

}
