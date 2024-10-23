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

    /**
     * 评分唯一标识符
     */
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 评分 (1-5分)
     */
    private Integer rating;

    /**
     * 评分时间
     */
    private LocalDateTime createdAt;


}
