package com.nnxx.domain.dto;

import com.nnxx.domain.enums.EducationalType;
import lombok.Data;


@Data
public class UsersDto {

    private String username;

    private String password;

    private String name;

    private String phone;

    private String email;

    private EducationalType educationalBackground;

    private String academicCertificate;
}
