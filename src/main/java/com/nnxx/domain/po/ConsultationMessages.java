package com.nnxx.domain.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.nnxx.domain.enums.ConsultationMessagesType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 咨询消息表
 * </p>
 *
 * @author 宁x
 * @since 2024-10-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("consultation_messages")
public class ConsultationMessages implements Serializable {


    /**
     * 咨询消息唯一标识符
     */
    private Long id;

    /**
     * 顾问ID（关联相应表）
     */
    private Long advisorId;

    /**
     * 申请人ID，外键
     */
    private Long applicantId;

    /**
     * 消息内容
     */
    private String content;

    /**
     * 消息时间
     */
    private LocalDateTime createdAt;


}
