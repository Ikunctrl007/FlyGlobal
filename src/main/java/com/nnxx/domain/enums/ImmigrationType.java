package com.nnxx.domain.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public enum ImmigrationType {
     SKILLED_MIGRATION(0,"技术移民"),INVEST_MIGRATION(1,"投资移民"),FAMILY_REUNION(2,"家庭团聚");
        @EnumValue
        private final Integer status;
        @JsonValue
        private final String desc;
}
