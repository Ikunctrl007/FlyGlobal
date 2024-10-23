package com.nnxx.domain.po;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 签证官员表
 * </p>
 *
 * @author 宁x
 * @since 2024-10-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("visa_officers")
public class VisaOfficers implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 签证官员唯一标识符
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 签证官员姓名
     */
    private String name;

    /**
     * 工作机构
     */
    private String agency;

    /**
     * 联系方式
     */
    private String contactInfo;

    /**
     * 签证官员评分
     */
    private BigDecimal rating;

    /**
     * 官员简介
     */
    private String bio;

    /**
     * 签证官员头像
     */
    private String profilePicture;


}
