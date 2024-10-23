package com.nnxx.domain.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public enum ForumPostsType {
        VISA(0,"签证板块"),IMMIGRANT(1,"移民板块"),STUDY_ABROAD(2,"留学板块");
        @EnumValue
        private final Integer status;
        @JsonValue
        private final String desc;
}
