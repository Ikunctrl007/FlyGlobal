package com.nnxx.service;

import com.nnxx.domain.Result;
import com.nnxx.domain.dto.ApplicationConsultantDto;
import com.nnxx.domain.dto.ApplicationsDto;
import com.nnxx.domain.po.Applications;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 申请信息表 服务类
 * </p>
 *
 * @author 宁x
 * @since 2024-10-23
 */
public interface IApplicationsService extends IService<Applications> {

    Result insert(ApplicationsDto applicationsDto);

    Result selectOne(Long userid,int id);

    Result updateOne(ApplicationConsultantDto applicationConsultantDto);

    Result selectAll(int id);

    Result selectAllApplication();

    Result updateApplication(Applications applications);

    Result deleteById(Long id);

    Result insertApplication(Applications applications);

    Result selectByAdvisors(Long userid);
}
