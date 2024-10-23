package com.nnxx.domain.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.nnxx.domain.enums.ForumPostsType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 帖子表
 * </p>
 *
 * @author 宁x
 * @since 2024-10-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("forum_posts")
public class ForumPosts implements Serializable {

    /**
     * 帖子唯一标识符
     */
    private Long id;

    /**
     * 版块类型（枚举类）
     */
    private ForumPostsType sectionType;

    /**
     * 提问用户ID
     */
    private Long userId;

    /**
     * 帖子内容
     */
    private String content;

    /**
     * 发布时间
     */
    private LocalDateTime createdAt;


}
