package com.nnxx.service;

import com.nnxx.domain.Result;
import com.nnxx.domain.po.Forum;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 论坛表，记录每个论坛帖子的基本信息 服务类
 * </p>
 *
 * @author 
 * @since 2025-03-23
 */
public interface IForumService extends IService<Forum> {

    Result selectAll();

    Result insert(Forum forum);

    Result delete(Long id);

    Result updateBy(Forum forum);
}
