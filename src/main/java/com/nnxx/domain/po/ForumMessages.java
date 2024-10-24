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
 * 论坛消息总表
 * </p>
 *
 * @author 宁x
 * @since 2024-10-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("forum_messages")
public class ForumMessages implements Serializable {

    /**
     * 论坛消息总表唯一标识符
     */
    private Long id;

    /**
     * 帖子ID
     */
    private Long postId;

    /**
     * 回答ID
     */
    private Long answerId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 消息时间
     */
    private LocalDateTime createdAt;


}
