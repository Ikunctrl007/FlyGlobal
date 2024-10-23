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
 * 签证申请表
 * </p>
 *
 * @author 宁x
 * @since 2024-10-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("visa_applications")
public class VisaApplications implements Serializable {

    /**
     * 签证申请唯一标识符
     */
    private Long id;

    /**
     * 用户ID，外键
     */
    private Long userId;

    /**
     * 签证类型(0旅游签证、1留学签证、2工作签证、3探亲签证、4申根签证)
     */
    private Integer visaType;

    /**
     * 材料清单
     */
    private String documents;

    /**
     * 预约日期和时间
     */
    private LocalDateTime appointmentDate;

    /**
     * 签证申请表理由
     */
    private String applicationForm;

    /**
     * 填写指导
     */
    private String formGuidance;

    /**
     * 申请状态（0申请中、1申请通过、2申请不通过)
     */
    private Integer status;

    /**
     * 最后更新时间
     */
    private LocalDateTime lastUpdated;


}
