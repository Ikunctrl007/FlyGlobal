package com.nnxx.domain.po;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.nnxx.domain.enums.CounselorType;
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
     * 顾问姓名
     */
    private String name;

    /**
     * 所属机构
     */
    private String firm;

    /**
     * 顾问专长 (1=留学申请、2=签证办理、3=移民咨询)
     */
    private CounselorType specialization;

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
