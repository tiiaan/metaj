package com.tiiaan.tbm.metaj.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 
 * </p>
 *
 * @author tiiaan
 * @since 2023-02-26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("tb_segment")
public class Segment implements Serializable {

    private static final long serialVersionUID = 1L;

    public Segment(Instance instance) {
        this(null, instance.getId(), 0, instance.getLongitude(), instance.getLatitude(), System.currentTimeMillis(), System.currentTimeMillis(), 0L, 0L, 0L, 0.0, null);
    }


    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 实例号
     */
    @TableField("instance_id")
    private Long instanceId;

    /**
     * 环号
     */
    @TableField("circle_seq")
    private Integer circleSeq;

    /**
     * 当前经度
     */
    @TableField("longitude")
    private Double longitude;

    /**
     * 当前纬度
     */
    @TableField("latitude")
    private Double latitude;

    /**
     * 环片开始时间
     */
    @TableField("start")
    private Long start;

    /**
     * 环片结束时间
     */
    @TableField("finish")
    private Long finish;

    /**
     * 推进时长
     */
    @TableField("prop_period")
    private Long propPeriod;

    /**
     * 拼装时长
     */
    @TableField("asm_period")
    private Long asmPeriod;

    /**
     * 停机时长
     */
    @TableField("stop_period")
    private Long stopPeriod;

    /**
     * 同步注浆量
     */
    @TableField("filling_amount")
    private Double fillingAmount;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;


}
