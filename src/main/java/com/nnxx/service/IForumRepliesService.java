package com.nnxx.service;

import com.nnxx.domain.Result;
import com.nnxx.domain.po.ForumReplies;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 论坛回复表，记录每个论坛帖子的回复信息 服务类
 * </p>
 *
 * @author 
 * @since 2025-03-23
 */
public interface IForumRepliesService extends IService<ForumReplies> {

    Result insert(ForumReplies forumReplies);

    Result selectAll();

    Result delete(Long id);

    Result selectById(Long id);

    Result updateBy(ForumReplies forumReplies);
}
