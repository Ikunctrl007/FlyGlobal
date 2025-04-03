package com.nnxx.mapper;

import com.nnxx.domain.po.Forum;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 论坛表，记录每个论坛帖子的基本信息 Mapper 接口
 * </p>
 *
 * @author 
 * @since 2025-03-23
 */
@Mapper
public interface ForumMapper extends BaseMapper<Forum> {

}
