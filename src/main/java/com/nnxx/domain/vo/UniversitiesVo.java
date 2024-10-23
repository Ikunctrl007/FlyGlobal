package com.nnxx.domain.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class UniversitiesVo {
    private Long id;
    private String collegeName;

    private String country;

    private BigDecimal tuition;

    private String languageRequirements;

    private LocalDate applicationDeadline;

    private String admissionStatistics;
}
