package com.nnxx.domain.vo;

import com.nnxx.domain.enums.EducationalType;
import com.nnxx.domain.enums.ImmigrationType;
import com.nnxx.domain.enums.UsersRole;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class LawyersInformationVo {
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 真实姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 性别
     */
    private String sex;

    /**
     * 出生日期
     */
    private LocalDate dateOfBirth;

    /**
     * 教育背景
     */
    private EducationalType educationalBackground;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 注册时间
     */
    private LocalDateTime registerTime;

    /**
     * 护照
     */
    private String passport;

    /**
     * 学历证明
     */
    private String academicCertificate;
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
     * 户籍地
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
}
