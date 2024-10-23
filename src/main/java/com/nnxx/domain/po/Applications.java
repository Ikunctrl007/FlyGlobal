package com.nnxx.domain.po;

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

    private static final long serialVersionUID = 1L;

    /**
     * 申请唯一标识符
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户ID，外键
     */
    private Integer userId;

    /**
     * 院校ID，外键
     */
    private Integer universityId;

    /**
     * 申请日期
     */
    private LocalDate applicationDate;

    /**
     * 申请状态
     */
    private Integer status;

    /**
     * 申请材料是否审核
     */
    private Integer materialsReviewed;

    /**
     * 审核建议
     */
    private String reviewSuggestions;


}
