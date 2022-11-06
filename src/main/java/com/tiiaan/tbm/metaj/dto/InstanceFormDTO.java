package com.tiiaan.tbm.metaj.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author tiiaan Email:tiiaan.w@gmail.com
 * @version 0.0
 * description
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InstanceFormDTO {

    private Long userId;

    @NotNull
    private String project;

    private Integer segments;

    private Long mileage;

    private Double longitude;

    private Double latitude;

}
