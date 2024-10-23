package com.nnxx.domain.vo;

import com.nnxx.domain.enums.EducationalType;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UsersVo {

    private String username;

    private String name;

    private String phone;

    private String email;

    private Integer sex;

    private LocalDate dateOfBirth;

    private EducationalType educationalBackground;

    private String avatar;

    private LocalDateTime registerTime;

    private String passport;

    private String academicCertificate;
}
