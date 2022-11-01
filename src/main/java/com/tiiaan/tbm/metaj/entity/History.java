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
@TableName("tb_history")
public class History implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("issue_id")
    private Long issueId;

    @TableField("instance_id")
    private Long instanceId;

    @TableField("time")
    private Long time;

    @TableField("main_torque")
    private Double mainTorque;

    @TableField("motor_torque")
    private Double motorTorque;

    @TableField("main_force")
    private Double mainForce;

    @TableField("bias_force")
    private Double biasForce;

    @TableField("asm_pressure")
    private Double asmPressure;

    @TableField("asm_temperature")
    private Double asmTemperature;

    @TableField("prop_pressure")
    private Double propPressure;

    @TableField("prop_temperature")
    private Double propTemperature;

    @TableField("bear_temperature")
    private Double bearTemperature;

    @TableField("bear_bolt_strain")
    private Double bearBoltStrain;


}
