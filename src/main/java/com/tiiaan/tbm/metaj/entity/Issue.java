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
@TableName("tb_issue")
public class Issue implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("user_id")
    private Long userId;

    @TableField("instance_id")
    private Long instanceId;

    @TableField("time")
    private Long time;

    @TableField("level")
    private Integer level;

    @TableField("title")
    private String title;

    @TableField("description")
    private String description;

    @TableField("images")
    private String images;

    @TableField("tracking")
    private Integer tracking;

    @TableField("comments")
    private Integer comments;

    @TableField("closed")
    private Integer closed;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;


}
