package com.nnxx.domain.dto;

import com.nnxx.domain.enums.VisaType;
import lombok.Data;

import java.time.LocalDateTime;
//签证咨询表
@Data
public class VisaApplicationsDto {
    private Long userId;

    private VisaType visaType;

    private String applicationForm;

    private LocalDateTime appointmentDate;
}
