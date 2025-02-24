package com.nnxx.domain.dto;

import com.nnxx.domain.enums.EducationalType;
import com.nnxx.domain.enums.UsersRole;
import lombok.Data;

import java.time.LocalDate;


@Data
public class UsersDto {

    private String username;

    private String password;

    private String name;

    private String phone;

    private String email;

    private String sex;

    private LocalDate dateOfBirth;

    private EducationalType educationalBackground;

    private String academicCertificate;
    private String oldAvatar;

    private String avatar;
    private UsersRole roleId;
}
