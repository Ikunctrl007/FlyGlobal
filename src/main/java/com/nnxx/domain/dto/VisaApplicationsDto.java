package com.nnxx.domain.dto;

import com.nnxx.domain.enums.VisaType;
import lombok.Data;

import java.time.LocalDateTime;
//签证咨询表
@Data
public class VisaApplicationsDto {
    private Long userId;
    private Long visaId;

    private VisaType visaType;

    private String documents;

    private String applicationForm;

    private LocalDateTime appointmentDate;
}
