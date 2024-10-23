package com.nnxx.domain.dto;

import lombok.Data;
//留学咨询表
@Data
public class ApplicationsDto {

    private Long userId;

    private Long universityId;

    private String profession;

    private String applicationMaterials;
}
