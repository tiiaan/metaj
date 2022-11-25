package com.tiiaan.tbm.metaj.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author tiiaan Email:tiiaan.w@gmail.com
 * @version 0.0
 * description
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InstanceStatusDTO {

    private Long timestamp;

    private Byte health;

    private Double mainTorque;

    private Double motorTorque;

    private Double mainForce;

    private Double biasForce;

    private Double asmPressure;

    private Double asmTemperature;

    private Double propPressure;

    private Double propTemperature;

    private Double bearTemperature;

    private Double bearBoltStrain;

}
