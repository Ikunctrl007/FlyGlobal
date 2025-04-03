package com.nnxx.domain.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 论坛回复表，记录每个论坛帖子的回复信息
 * </p>
 *
 * @author 
 * @since 2025-03-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("forum_replies")
public class ForumReplies implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 回复的唯一ID，自动递增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 关联的论坛ID，外键关联论坛表
     */
    private Long forumId;

    /**
     * 回复用户的ID，外键关联用户表
     */
    private Long userId;

    /**
     * 回复的内容
     */
    private String content;

    /**
     * 回复的创建时间，默认当前时间
     */
    private LocalDateTime createdAt;


}
