package com.nnxx.service.impl;

import com.nnxx.domain.po.ForumMessages;
import com.nnxx.mapper.ForumMessagesMapper;
import com.nnxx.service.IForumMessagesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 论坛消息总表 服务实现类
 * </p>
 *
 * @author 宁x
 * @since 2024-10-23
 */
@Service
public class ForumMessagesServiceImpl extends ServiceImpl<ForumMessagesMapper, ForumMessages> implements IForumMessagesService {

}
