package com.nnxx.domain.po;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 留学顾问表
 * </p>
 *
 * @author 宁x
 * @since 2024-10-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("study_advisors")
public class StudyAdvisors implements Serializable {

    /**
     * 留学顾问唯一标识符
     */
    private Long id;
    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 顾问姓名
     */
    private String name;

    /**
     * 所属机构
     */
    private String firm;

    /**
     * 顾问经验年数
     */
    private Integer experienceYears;

    /**
     * 联系方式
     */
    private String contactInfo;

    /**
     * 顾问评分
     */
    private BigDecimal rating;

    /**
     * 顾问简介
     */
    private String bio;

    /**
     * 顾问头像
     */
    private String profilePicture;


}
