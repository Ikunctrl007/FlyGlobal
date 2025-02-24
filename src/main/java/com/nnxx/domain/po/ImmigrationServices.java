package com.nnxx.domain.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.nnxx.domain.enums.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 移民咨询与服务表
 * </p>
 *
 * @author 宁x
 * @since 2024-10-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("immigration_services")
public class ImmigrationServices implements Serializable {

    /**
     * 移民服务唯一标识符
     */
    private Long id;

    /**
     * 用户ID，外键
     */
    private Long userId;

    /**
     * 用户职业背景，1学生、2社会人员
     */
    private OccupationType professionBackground;

    /**
     * 用户家庭情况
     */
    private String familySituation;

    /**
     * 目标国家
     */
    private String targetCountry;

    /**
     * 移民类型
     */
    private ImmigrationType immigrationType;

    /**
     * 个性化移民方案
     */
    private String personalizedPlan;

    /**
     * 移民律师ID，外键
     */
    private Long lawyerId;

    /**
     * 咨询日期
     */
    private LocalDateTime consultationDate;

    /**
     * 最后更新时间
     */
    private LocalDateTime lastUpdated;
    /**
     * 咨询状态（0未回复、1已回复)
     */
    private ImmigrationStatus status;


}
