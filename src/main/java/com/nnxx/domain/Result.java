package com.nong.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer status;
    private String msg;
    private Object data;

    public Result(Integer status, Object data) {
        this.status = status;
        this.data = data;
    }
    public Result(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
