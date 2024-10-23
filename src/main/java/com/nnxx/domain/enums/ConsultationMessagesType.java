package com.nnxx.domain.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ConsultationMessagesType {
    STUDY_ABROAD_CONSULTANT(0,"留学顾问"),IMMIGRATION_LAWYER(1,"移民律师"),VISA_OFFICER(2,"签证官员");
    @EnumValue
    private final Integer value;
    @JsonValue
    private final String desc;
}
