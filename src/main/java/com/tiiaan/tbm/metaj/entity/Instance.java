package com.tiiaan.tbm.metaj.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
@TableName("tb_instance")
public class Instance implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField(exist = false)
    private Boolean isWatching;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("user_id")
    private Long userId;

    @TableField("name")
    private String name;

    @TableField("project")
    private String project;

    @TableField("segments")
    private Integer segments;

    @TableField("mileage")
    private Long mileage;

    @TableField("longitude")
    private Double longitude;

    @TableField("latitude")
    private Double latitude;

    @TableField("health")
    private Integer health;

    @TableField("current_segment")
    private Integer currentSegment;

    @TableField("warns")
    private Integer warns;

    @TableField("issues")
    private Integer issues;

    @TableField("unsolved_issues")
    private Integer unsolvedIssues;

    @TableField("unclosed_issues")
    private Integer unclosedIssues;

    @TableField("watching")
    private Long watching;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;


}
