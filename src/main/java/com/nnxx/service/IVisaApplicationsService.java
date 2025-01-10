package com.nnxx.service;

import com.nnxx.domain.Result;
import com.nnxx.domain.dto.VisaApplicationsDto;
import com.nnxx.domain.dto.VisaApplicationsVisaDto;
import com.nnxx.domain.po.VisaApplications;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 签证申请表 服务类
 * </p>
 *
 * @author 宁x
 * @since 2024-10-23
 */
public interface IVisaApplicationsService extends IService<VisaApplications> {

    Result insert(VisaApplicationsDto visaApplicationsDto);

    Result selectByUser(Long id);

    Result selectById(Long id);

    Result updateByApplicationId(VisaApplicationsVisaDto visaApplicationsVisaDto);

    Result selectAll();

    Result deleteById(Long id);

    Result updateByApplication(VisaApplications visaApplications);
}
