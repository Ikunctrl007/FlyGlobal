package com.nnxx.service.impl;

import com.nnxx.domain.Code;
import com.nnxx.domain.Result;
import com.nnxx.domain.po.ForumReplies;
import com.nnxx.mapper.ForumRepliesMapper;
import com.nnxx.service.IForumRepliesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 论坛回复表，记录每个论坛帖子的回复信息 服务实现类
 * </p>
 *
 * @author 
 * @since 2025-03-23
 */
@Service
public class ForumRepliesServiceImpl extends ServiceImpl<ForumRepliesMapper, ForumReplies> implements IForumRepliesService {
    /**
     * 查询所有论坛消息
     * @return 返回所有论坛消息的结果
     */
    @Override
    public Result selectAll() {
        List<ForumReplies> list = list();  // 获取所有论坛消息
        int status = list != null ? Code.SELECT_YES : Code.SELECT_ERROR;
        String msg = list != null ? "查询成功" : "查询失败";
        return new Result(status, msg, list);  // 返回结果
    }

    /**
     * 添加一条新的论坛消息
     * @return 插入结果
     */
    @Override
    public Result insert(ForumReplies forumReplies) {
        boolean saveSuccess = save(forumReplies);  // 插入论坛消息
        int status = saveSuccess ? Code.SELECT_YES : Code.SELECT_ERROR;
        String msg = saveSuccess ? "插入成功" : "插入失败";
        return new Result(status, msg, null);  // 返回插入结果
    }

    /**
     * 删除指定ID的论坛消息
     * @param id 论坛消息ID
     * @return 删除结果
     */
    @Override
    public Result delete(Long id) {
        boolean deleteSuccess = removeById(id);  // 删除论坛消息
        int status = deleteSuccess ? Code.SELECT_YES : Code.SELECT_ERROR;
        String msg = deleteSuccess ? "删除成功" : "删除失败";
        return new Result(status, msg, null);  // 返回删除结果
    }

    @Override
    public Result selectById(Long id) {
        List<ForumReplies> list = lambdaQuery().eq(ForumReplies::getForumId, id).list();
        int status = list != null ? Code.SELECT_YES : Code.SELECT_ERROR;
        String msg = list != null ? "查询成功" : "查询失败";
        return new Result(status, msg, list);  // 返回结果
    }

    @Override
    public Result updateBy(ForumReplies forumReplies) {
        boolean saveSuccess = updateById(forumReplies);  // 插入论坛消息
        int status = saveSuccess ? Code.SELECT_YES : Code.SELECT_ERROR;
        String msg = saveSuccess ? "插入成功" : "插入失败";
        return new Result(status, msg, null);  // 返回插入结果
    }
}
