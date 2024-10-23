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

    private static final long serialVersionUID = 1L;

    /**
     * 咨询消息唯一标识符
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 顾问类型（1=留学顾问，2=移民律师，3=签证官员）
     */
    private Integer advisorType;

    /**
     * 顾问ID（关联相应表）
     */
    private Integer advisorId;

    /**
     * 申请人ID，外键
     */
    private Integer applicantId;

    /**
     * 消息内容
     */
    private String content;

    /**
     * 消息时间
     */
    private LocalDateTime createdAt;


}
