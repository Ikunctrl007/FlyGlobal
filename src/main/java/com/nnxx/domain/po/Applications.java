package com.nnxx.domain.po;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.sql.Date;

import com.nnxx.domain.enums.ApplicationsStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 申请信息表
 * </p>
 *
 * @author 宁x
 * @since 2024-10-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("applications")
public class Applications implements Serializable {

    /**
     * 申请唯一标识符
     */
    private Long id;

    /**
     * 用户ID，外键
     */
    private Long userId;

    /**
     * 顾问ID
     */
    private Long advisorsId;

    /**
     * 院校ID，外键
     */
    private Long universityId;

    /**
     * 专业
     */
    private String profession;

    /**
     * 申请材料
     */
    private String applicationMaterials;

    /**
     * 申请日期
     */
    private Date applicationDate;

    /**
     * 申请状态
     */
    private ApplicationsStatus status;

    /**
     * 审核建议
     */
    private String reviewSuggestions;


}
