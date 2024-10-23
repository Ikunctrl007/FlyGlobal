package com.nnxx.service.impl;

import com.nnxx.domain.po.Applications;
import com.nnxx.mapper.ApplicationsMapper;
import com.nnxx.service.IApplicationsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 申请信息表 服务实现类
 * </p>
 *
 * @author 宁x
 * @since 2024-10-23
 */
@Service
public class ApplicationsServiceImpl extends ServiceImpl<ApplicationsMapper, Applications> implements IApplicationsService {

}
