package com.nnxx.domain.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApplicationsStatus {
    EXAMINE_ING(0,"申请中"),EXAMINE_SUCCESS(1,"申请通过"),EXAMINE_ERROR(2,"申请不通过");
    @EnumValue
    private final Integer status;
    @JsonValue
    private final String desc;
}
