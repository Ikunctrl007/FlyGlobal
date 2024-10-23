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
 * 咨询评分表
 * </p>
 *
 * @author 宁x
 * @since 2024-10-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("consultation_ratings")
public class ConsultationRatings implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 评分唯一标识符
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 消息ID，外键
     */
    private Integer messageId;

    /**
     * 评分 (1-5分)
     */
    private Integer rating;

    /**
     * 用户反馈
     */
    private String feedback;

    /**
     * 评分时间
     */
    private LocalDateTime createdAt;


}
