package com.nnxx.domain.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public enum UsersRole {
        NORMAL_USER(0,"普通用户"),
        STUDY_ABROAD_CONSULTANT(1,"留学顾问"),
        IMMIGRATION_LAWYER(2,"移民律师"),
        VISA_OFFICER(3,"签证官员"),
        SUPER_ADMINISTRATOR(4,"超级管理员");
        @EnumValue
        private final Integer status;
        @JsonValue
        private final String desc;

}
