package com.nnxx.domain.po;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 院校信息表
 * </p>
 *
 * @author 宁x
 * @since 2024-10-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("universities")
public class Universities implements Serializable {

    /**
     * 院校唯一标识符
     */
    private Long id;

    /**
     * 院校名称
     */
    private String collegeName;

    /**
     * 院校所在国家
     */
    private String country;

    /**
     * 学费
     */
    private BigDecimal tuition;

    /**
     * 语言要求
     */
    private String languageRequirements;

    /**
     * 申请截止日期
     */
    private LocalDate applicationDeadline;

    /**
     * 往年学生录取情况
     */
    private String admissionStatistics;


}
