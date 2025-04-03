package com.nnxx.controller;


import com.nnxx.domain.Result;
import com.nnxx.domain.po.Forum;
import com.nnxx.domain.po.ForumReplies;
import com.nnxx.service.IForumRepliesService;
import com.nnxx.util.ParseTokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 论坛回复表，记录每个论坛帖子的回复信息 前端控制器
 * </p>
 *
 * @author 
 * @since 2025-03-23
 */
@RestController
@RequestMapping("/forum-replies")
@RequiredArgsConstructor
public class ForumRepliesController {
    private final IForumRepliesService service;

    /**
     * 获取所有论坛消息
     * @return Result 返回所有论坛消息的结果
     */
    @GetMapping("/list")
    public Result selectAll() {
        return service.selectAll();  // 调用服务层方法获取所有论坛消息
    }

    /**
     * 添加一条新的论坛消息
     * @return Result 返回插入的结果
     */
    @PostMapping("/admin")
    public Result insert(@RequestBody ForumReplies forumReplies) {
        return service.insert(forumReplies);  // 调用服务层方法插入新的论坛消息
    }
    /**
     * 用户添加论坛回复消息
     */
    @PostMapping
    public Result insertByUser(@RequestHeader("Authorization") String token,@RequestBody ForumReplies forumReplies) {
        Long userId = ParseTokenUtils.parseToken(token);
        forumReplies.setUserId(userId);
        return service.insert(forumReplies);  // 调用服务层方法插入新的论坛回答
    }
    /**
     * 修改论坛消息
     * @return Result 返回插入的结果
     */
    @PutMapping
    public Result updateBy(@RequestBody ForumReplies forumReplies) {
        return service.updateBy(forumReplies);  // 调用服务层方法插入新的论坛消息
    }

    /**
     * 删除指定ID的论坛消息
     * @param id 论坛消息ID
     * @return Result 返回删除操作的结果
     */
    @DeleteMapping("/id/{id}")
    public Result delete(@PathVariable("id") Long id) {
        return service.delete(id);  // 调用服务层方法删除指定ID的论坛消息
    }
    //根据论坛id查询
    @GetMapping("/id/{id}")
    public Result selectById(@PathVariable Long id){
        return service.selectById(id);
    }

}
