package com.nnxx.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.db.Db;
import com.nnxx.domain.Code;
import com.nnxx.domain.Result;
import com.nnxx.domain.dto.VisaApplicationsDto;
import com.nnxx.domain.dto.VisaApplicationsVisaDto;
import com.nnxx.domain.po.Applications;
import com.nnxx.domain.po.VisaApplications;
import com.nnxx.domain.po.VisaOfficers;
import com.nnxx.mapper.VisaApplicationsMapper;
import com.nnxx.service.IVisaApplicationsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nnxx.service.IVisaOfficersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 签证申请表 服务实现类
 * </p>
 *
 * @author 宁x
 * @since 2024-10-23
 */
@Service
public class VisaApplicationsServiceImpl extends ServiceImpl<VisaApplicationsMapper, VisaApplications> implements IVisaApplicationsService {
    @Autowired
    private IVisaOfficersService service;
    @Override
    public Result insert(VisaApplicationsDto visaApplicationsDto) {
        VisaApplications visaApplications = BeanUtil.copyProperties(visaApplicationsDto, VisaApplications.class);
        boolean flag = save(visaApplications);
        int status = flag? Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = flag?"添加成功":"添加失败";
        return new Result(status,msg);
    }

    @Override
    public Result selectByUser(Long id) {
        List<VisaApplications> list = lambdaQuery().eq(id != null, VisaApplications::getUserId, id).list();
        int status = list!=null?Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = list!=null?"查询成功":"查询失败";
        return new Result(status,msg,list);
    }

    @Override
    public Result selectById(Long id) {
        VisaOfficers visaOfficers = service.lambdaQuery().eq(id != null, VisaOfficers::getUserId, id).one();
        Long visaId = visaOfficers.getId();
        List<VisaApplications> list = lambdaQuery().eq(visaId != null, VisaApplications::getVisaId, visaId).list();
        int status = list!=null?Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = list!=null?"查询成功":"查询失败";
        return new Result(status,msg,list);
    }

    @Override
    public Result updateByApplicationId(VisaApplicationsVisaDto visaApplicationsVisaDto) {
        VisaApplications visaApplications = BeanUtil.copyProperties(visaApplicationsVisaDto, VisaApplications.class);
        boolean flag = updateById(visaApplications);
        int status = flag? Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = flag?"修改成功":"修改失败";
        return new Result(status,msg);
    }

    @Override
    public Result selectAll() {
        List<VisaApplications> list = list();
        int status = list!=null?Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = list!=null?"查询成功":"查询失败";
        return new Result(status,msg,list);
    }

    @Override
    public Result deleteById(Long id) {
        boolean flag = removeById(id);
        int status = flag? Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = flag?"删除成功":"删除失败";
        return new Result(status,msg);
    }

    @Override
    public Result updateByApplication(VisaApplications visaApplications) {
        visaApplications.setLastUpdated(LocalDateTime.now());
        boolean flag = updateById(visaApplications);
        int status = flag? Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = flag?"修改成功":"修改失败";
        return new Result(status,msg);
    }

    @Override
    public Result insertVisaApplication(VisaApplications visaApplications) {
        boolean flag = save(visaApplications);
        int status = flag? Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = flag?"添加成功":"添加失败";
        return new Result(status,msg);
    }

    @Override
    public Result selectAllByStatus(int id) {
        List<VisaApplications> list = lambdaQuery()
                .eq( VisaApplications::getStatus, id)
                .list();
        int status = list!=null? Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = list!=null?"查询成功":"查询失败";
        return new Result(status,msg,list);
    }

}
