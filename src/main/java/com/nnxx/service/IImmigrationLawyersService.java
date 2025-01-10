package com.nnxx.service;

import com.nnxx.domain.Result;
import com.nnxx.domain.po.ImmigrationLawyers;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 移民律师表 服务类
 * </p>
 *
 * @author 宁x
 * @since 2024-10-23
 */
public interface IImmigrationLawyersService extends IService<ImmigrationLawyers> {

    Result insertOne(ImmigrationLawyers immigrationLawyers);

    Result updateOne(ImmigrationLawyers immigrationLawyers);

    Result delete(Integer id);

    Result selectOne(Long id);

    Result selectAll();

}
