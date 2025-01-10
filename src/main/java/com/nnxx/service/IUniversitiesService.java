package com.nnxx.service;

import com.nnxx.domain.Result;
import com.nnxx.domain.po.Universities;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 院校信息表 服务类
 * </p>
 *
 * @author 宁x
 * @since 2024-10-23
 */
public interface IUniversitiesService extends IService<Universities> {

    Result selectAll();

    Result selectByName(String collegeName);

    Result insert(Universities universities);

    Result updateByCollegeId(Universities universities);

    Result deleteById(Long id);
}
