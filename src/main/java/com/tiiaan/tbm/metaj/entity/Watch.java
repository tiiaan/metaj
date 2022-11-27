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
@TableName("tb_watch")
public class Watch implements Serializable {

    private static final long serialVersionUID = 1L;

    public Watch(Long userId, Long instanceId) {
        this.userId = userId;
        this.instanceId = instanceId;
    }

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("user_id")
    private Long userId;

    @TableField("instance_id")
    private Long instanceId;

    @TableField("create_time")
    private LocalDateTime createTime;


}
