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
 * 回答表
 * </p>
 *
 * @author 宁x
 * @since 2024-10-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("forum_answers")
public class ForumAnswers implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 回答唯一标识符
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 帖子ID
     */
    private Integer postId;

    /**
     * 回答用户ID
     */
    private Integer userId;

    /**
     * 回答内容
     */
    private String content;

    /**
     * 回答时间
     */
    private LocalDateTime createdAt;


}
