package com.tiiaan.tbm.metaj.dto;

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
public class InstanceDTO {

    private String name;

    private String project;

    private Integer segments;

    private Long mileage;

}
