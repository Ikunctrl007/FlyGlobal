package com.nnxx.domain.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OccupationType {
    STUDENT(0,"学生"),SOCIAL_PERSONNEL(1,"社会人员");
    @EnumValue
    private final Integer status;
    @JsonValue
    private final String desc;
}
