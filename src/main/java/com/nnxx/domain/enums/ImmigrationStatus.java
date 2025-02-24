package com.nnxx.domain.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ImmigrationStatus {
    EXAMINE_ING(0,"未回复"),EXAMINE_SUCCESS(1,"已回复");
    @EnumValue
    private final Integer status;
    @JsonValue
    private final String desc;
}
