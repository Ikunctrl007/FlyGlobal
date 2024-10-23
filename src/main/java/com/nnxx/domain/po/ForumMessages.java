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

    private static final long serialVersionUID = 1L;

    /**
     * 论坛消息总表唯一标识符
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 帖子ID
     */
    private Integer postId;

    /**
     * 回答ID
     */
    private Integer answerId;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 消息时间
     */
    private LocalDateTime createdAt;


}
