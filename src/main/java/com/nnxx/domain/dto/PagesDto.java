package com.nnxx.domain.dto;

import lombok.Data;

@Data
public class PagesDto {
    //第几页
    private long page;
    //一页显示几条
    private long size;
    //排序条件
    private String sortBy;
    //是否升序
    private boolean isAsc;
}
