package com.tiiaan.tbm.metaj.mapper;

import com.tiiaan.tbm.metaj.entity.Issue;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tiiaan
 * @since 2023-02-26
 */
public interface IssueMapper extends BaseMapper<Issue> {

    List<Issue> queryIssuesByInstanceIdDynamic(@Param("start") Integer start, @Param("pageSize") Integer pageSize, @Param("instanceId") Long instanceId, @Param("closed") Integer closed, @Param("userId") Long userId);

}
