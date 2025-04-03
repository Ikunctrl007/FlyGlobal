package com.nnxx.domain.dto;

import lombok.Data;

import java.sql.Date;

//留学咨询表
@Data
public class ApplicationsDto {

    private Long userId;
    private Long advisorsId;

    private Long universityId;

    private String profession;

    private Date applicationDate;

    private String applicationMaterials;
}
