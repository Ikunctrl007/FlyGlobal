package com.nnxx.domain.dto;

import com.nnxx.domain.enums.ImmigrationType;
import com.nnxx.domain.enums.OccupationType;
import lombok.Data;

import java.time.LocalDateTime;
//移民咨询表
@Data
public class ImmigrationServicesDto {
    private Long userId;

    private OccupationType professionBackground;

    private String familySituation;

    private String targetCountry;

    private ImmigrationType immigrationType;

    private Long lawyerId;

    private LocalDateTime lastUpdated;
}
