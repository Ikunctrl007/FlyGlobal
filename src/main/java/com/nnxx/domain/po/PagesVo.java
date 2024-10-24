package com.nnxx.domain.po;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PagesVo<T> {
    private long total;
    private long pages;
    private List<T> data;
}
