package com.nnxx.domain.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ImmigrationDto {
    private String personalizedPlan;
    private LocalDateTime lastUpdated;
}
