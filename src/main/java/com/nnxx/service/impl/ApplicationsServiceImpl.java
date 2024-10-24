package com.nnxx.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.nnxx.domain.Code;
import com.nnxx.domain.Result;
import com.nnxx.domain.dto.ApplicationConsultantDto;
import com.nnxx.domain.dto.ApplicationsDto;
import com.nnxx.domain.po.Applications;
import com.nnxx.domain.po.Users;
import com.nnxx.mapper.ApplicationsMapper;
import com.nnxx.service.IApplicationsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

    @Override
    public Result insert(ApplicationsDto applicationsDto) {
        if(Objects.isNull(applicationsDto)){
            return new Result(Code.SELECT_ERROR,"信息不可为空");
        }
        Applications applications = BeanUtil.copyProperties(applicationsDto, Applications.class);
        boolean flag = save(applications);
        int status = flag? Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = flag?"添加成功":"添加失败";
        return new Result(status,msg);
    }

    @Override
    public Result selectOne(Long userid,int id) {
        List<Applications> list = lambdaQuery()
                .eq(userid != null, Applications::getUserId, userid)
                .eq(Applications::getStatus,id)
                .list();
        int status = list!=null? Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = list!=null?"查询成功":"查询失败";
        return new Result(status,msg,list);
    }

    @Override
    public Result updateOne(ApplicationConsultantDto applicationConsultantDto) {
        if(Objects.isNull(applicationConsultantDto)){
            return new Result(Code.SELECT_ERROR,"信息不可为空");
        }
        Applications applications = BeanUtil.copyProperties(applicationConsultantDto, Applications.class);
        boolean flag = updateById(applications);
        int status = flag? Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = flag?"修改成功":"修改失败";
        return new Result(status,msg);
    }

    @Override
    public Result selectAll(int id) {
        List<Applications> list = lambdaQuery()
                .eq( Applications::getStatus, id)
                .list();
        int status = list!=null? Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = list!=null?"查询成功":"查询失败";
        return new Result(status,msg,list);
    }
}
