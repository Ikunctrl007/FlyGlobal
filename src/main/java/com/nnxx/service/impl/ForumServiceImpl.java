package com.nnxx.service.impl;

import com.nnxx.domain.Code;
import com.nnxx.domain.Result;
import com.nnxx.domain.po.Forum;
import com.nnxx.mapper.ForumMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nnxx.service.IForumService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 回答表 服务实现类
 * </p>
 *
 * @author 宁x
 * @since 2024-10-23
 */
@Service
public class ForumServiceImpl extends ServiceImpl<ForumMapper, Forum> implements IForumService {
    /**
     * 查询所有论坛回答
     * @return 返回查询结果
     */
    @Override
    public Result selectAll() {
        // 使用 MyBatis-Plus 的 list() 方法获取所有论坛回答
        List<Forum> list = list();
        int status = list != null ? Code.SELECT_YES : Code.SELECT_ERROR;
        String msg = list != null ? "查询成功" : "查询失败";
        return new Result(status, msg, list);  // 返回查询结果
    }

    /**
     * 添加一个新的论坛回答
     * @return 返回插入结果
     */
    @Override
    public Result insert(Forum forum) {
        // 调用 MyBatis-Plus 的 save() 方法插入论坛回答
        boolean saveSuccess = save(forum);
        int status = saveSuccess ? Code.SELECT_YES : Code.SELECT_ERROR;
        String msg = saveSuccess ? "插入成功" : "插入失败";
        return new Result(status, msg, null);  // 返回插入结果
    }

    /**
     * 删除指定的论坛回答
     * @param id 论坛回答ID
     * @return 返回删除结果
     */
    @Override
    public Result delete(Long id) {
        // 调用 MyBatis-Plus 的 removeById() 方法删除指定ID的论坛回答
        boolean deleteSuccess = removeById(id);
        int status = deleteSuccess ? Code.SELECT_YES : Code.SELECT_ERROR;
        String msg = deleteSuccess ? "删除成功" : "删除失败";
        return new Result(status, msg, null);  // 返回删除结果
    }

    @Override
    public Result updateBy(Forum forum) {
        // 调用 MyBatis-Plus 的 save() 方法插入论坛回答
        boolean saveSuccess = updateById(forum);
        int status = saveSuccess ? Code.SELECT_YES : Code.SELECT_ERROR;
        String msg = saveSuccess ? "插入成功" : "插入失败";
        return new Result(status, msg, null);  // 返回插入结果
    }
}
