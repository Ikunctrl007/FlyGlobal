package com.nnxx.domain.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public enum EducationalType {
    PRIMARY_SCHOOL(0,"小学"),
    JUNIOR_HIGH_SCHOOL(1,"初中"),
    SENIOR_HIGH_SCHOOL(2,"高中"),
    JUNIOR_COLLEGE(3,"专科"),
    UNDERGRADUATE_COURSE(4,"本科"),
    GRADUATE_STUDENT(5,"研究生"),
    LEARNED_SCHOLAR(6,"博士");
        @EnumValue
        private final Integer status;
        @JsonValue
        private final String desc;
}
