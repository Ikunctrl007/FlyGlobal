package com.nnxx.domain.vo;

import com.nnxx.domain.enums.ApplicationsStatus;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ApplicationsVo {

    private Long id;

    private Long universityId;

    private String profession;

    private String applicationMaterials;

    private LocalDateTime applicationDate;

    private ApplicationsStatus status;

    private String reviewSuggestions;

    private UniversitiesVo universitiesInfo;
}
