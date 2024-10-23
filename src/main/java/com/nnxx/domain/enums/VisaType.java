package com.nnxx.domain.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public enum VisaType {
        TOURIST_VISA(0,"旅游签证"),
    STUDY_ABROAD_VISA(1,"留学签证"),
    PROFESSIONAL_VISA(2,"工作签证"),
    FAMILY_VISA(3,"探亲签证"),
    SCHEMAGEN_VISA(4,"申根签证");
    @EnumValue
        private final Integer status;
        @JsonValue
        private final String desc;
}
