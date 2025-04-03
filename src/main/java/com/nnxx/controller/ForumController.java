package com.nnxx.controller;


import com.nnxx.domain.Result;
import com.nnxx.domain.po.Forum;
import com.nnxx.service.IForumService;
import com.nnxx.util.ParseTokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 论坛表，记录每个论坛帖子的基本信息 前端控制器
 * </p>
 *
 * @author 
 * @since 2025-03-23
 */
@RestController
@RequestMapping("/forum")
@RequiredArgsConstructor
public class ForumController {
    private final IForumService service;

    /**
     * 获取所有论坛回答
     * @return Result 返回所有论坛回答的结果
     */
    @GetMapping("/list")
    public Result selectAll() {
        return service.selectAll();  // 调用服务层方法获取所有回答
    }

    /**
     * 添加新的论坛回答
     * @return Result 返回操作结果
     */
    @PostMapping("/admin")
    public Result insert(@RequestBody Forum forum) {
        return service.insert(forum);  // 调用服务层方法插入新的论坛回答
    }
    /**
     * 用户添加论坛消息
     */
    @PostMapping
    public Result insertByUser(@RequestHeader("Authorization") String token,@RequestBody Forum forum) {
        Long userId = ParseTokenUtils.parseToken(token);
        forum.setUserId(userId);
        return service.insert(forum);  // 调用服务层方法插入新的论坛回答
    }

    /**
     * 修改论坛回答
     * @return Result 返回操作结果
     */
    @PutMapping
    public Result updateBy(@RequestBody Forum forum) {
        return service.updateBy(forum);  // 调用服务层方法插入新的论坛回答
    }

    /**
     * 删除指定的论坛回答
     * @param id 论坛回答ID
     * @return Result 返回删除操作的结果
     */
    @DeleteMapping("/id/{id}")
    public Result delete(@PathVariable("id") Long id) {
        return service.delete(id);  // 调用服务层方法删除指定ID的论坛回答
    }

}
