package com.nnxx.domain.dto;

import com.nnxx.domain.enums.ApplicationsStatus;
import lombok.Data;

@Data
public class VisaApplicationsVisaDto {
    private Long id;
    private String formGuidance;
    private ApplicationsStatus status;
}
