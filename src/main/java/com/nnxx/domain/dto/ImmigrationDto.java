package com.nnxx.domain.dto;

import com.nnxx.domain.enums.ImmigrationStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ImmigrationDto {
    private Long id;
    private ImmigrationStatus status;
    private String personalizedPlan;
}
