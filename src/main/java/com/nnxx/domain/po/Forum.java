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
 * 论坛表，记录每个论坛帖子的基本信息
 * </p>
 *
 * @author 
 * @since 2025-03-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("forum")
public class Forum implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 论坛的唯一ID，自动递增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 论坛的标题
     */
    private String title;

    /**
     * 论坛的内容
     */
    private String content;

    /**
     * 发帖用户的ID，外键关联用户表
     */
    private Long userId;

    /**
     * 论坛的创建时间，默认当前时间
     */
    private LocalDateTime createdAt;


}
