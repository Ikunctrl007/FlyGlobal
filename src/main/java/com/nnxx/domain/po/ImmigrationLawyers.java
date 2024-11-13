package com.nnxx.domain.po;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import com.nnxx.domain.enums.ImmigrationType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 移民律师表
 * </p>
 *
 * @author 宁x
 * @since 2024-10-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("immigration_lawyers")
public class ImmigrationLawyers implements Serializable {
    /**
     * 律师唯一标识符
     */
    private Long id;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 律师姓名
     */
    private String name;

    /**
     * 所属律所
     */
    private String firm;

    /**
     * 律师专长,1技术移民、2投资移民、3家庭团聚
     */
    private ImmigrationType specialization;

    /**
     * 律师经验年数
     */
    private Integer experienceYears;

    /**
     * 联系方式
     */
    private String contactInfo;

    /**
     * 律师评分
     */
    private BigDecimal rating;

    /**
     * 律师简介
     */
    private String bio;
    /**
     * 头像
     */
    private String profilePicture;


}
