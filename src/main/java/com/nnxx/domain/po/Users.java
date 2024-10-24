package com.nnxx.domain.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.nnxx.domain.enums.EducationalType;
import com.nnxx.domain.enums.UsersRole;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author 宁x
 * @since 2024-10-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("users")
public class Users implements Serializable {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 用户角色
     */
    private UsersRole role;
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

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


}
