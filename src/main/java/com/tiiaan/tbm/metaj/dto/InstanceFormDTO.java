package com.tiiaan.tbm.metaj.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
public class InstanceFormDTO {

    private String project;

    private Integer segments;

    private Long mileage;

    private Double longitude;

    private Double latitude;

}
