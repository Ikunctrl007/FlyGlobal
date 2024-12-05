package com.nnxx.service;

import com.nnxx.domain.Result;
import com.nnxx.domain.dto.ImmigrationDto;
import com.nnxx.domain.dto.ImmigrationServicesDto;
import com.nnxx.domain.po.ImmigrationServices;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 移民咨询与服务表 服务类
 * </p>
 *
 * @author 宁x
 * @since 2024-10-23
 */
public interface IImmigrationServicesService extends IService<ImmigrationServices> {

    Result insert(ImmigrationServicesDto immigrationServicesDto);

    Result selectByUser(Long id);

    Result selectByImmigration(Long id);

    Result updateByUser(ImmigrationDto immigrationDto);

    Result deleteById(long id);
}
