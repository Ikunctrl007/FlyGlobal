package com.nnxx.service;

import com.nnxx.domain.Result;
import com.nnxx.domain.po.VisaOfficers;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 签证官员表 服务类
 * </p>
 *
 * @author 宁x
 * @since 2024-10-23
 */
public interface IVisaOfficersService extends IService<VisaOfficers> {

    Result insertOne(VisaOfficers visaOfficers);

    Result updateOne(VisaOfficers visaOfficers);

    Result delete(Integer id);

    Result selectOne(Long id);

    Result selectAll();

}
