package com.nnxx.domain.dto;

import com.nnxx.domain.enums.ApplicationsStatus;
import lombok.Data;

@Data
public class ApplicationConsultantDto {
    private Long id;

    private ApplicationsStatus status;

    private String reviewSuggestions;
}
