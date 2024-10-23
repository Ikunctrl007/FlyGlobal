package com.nnxx.service.impl;

import com.nnxx.domain.po.ForumPosts;
import com.nnxx.mapper.ForumPostsMapper;
import com.nnxx.service.IForumPostsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 帖子表 服务实现类
 * </p>
 *
 * @author 宁x
 * @since 2024-10-23
 */
@Service
public class ForumPostsServiceImpl extends ServiceImpl<ForumPostsMapper, ForumPosts> implements IForumPostsService {

}
