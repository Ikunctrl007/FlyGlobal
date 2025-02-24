package com.nnxx.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.nnxx.domain.Code;
import com.nnxx.domain.Result;
import com.nnxx.domain.dto.ImmigrationDto;
import com.nnxx.domain.dto.ImmigrationServicesDto;
import com.nnxx.domain.po.ImmigrationLawyers;
import com.nnxx.domain.po.ImmigrationServices;
import com.nnxx.mapper.ImmigrationServicesMapper;
import com.nnxx.service.IImmigrationLawyersService;
import com.nnxx.service.IImmigrationServicesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 移民咨询与服务表 服务实现类
 * </p>
 *
 * @author 宁x
 * @since 2024-10-23
 */
@Service
@RequiredArgsConstructor
public class ImmigrationServicesServiceImpl extends ServiceImpl<ImmigrationServicesMapper, ImmigrationServices> implements IImmigrationServicesService {

    private final IImmigrationLawyersService service;
    @Override
    public Result insert(ImmigrationServicesDto immigrationServicesDto) {
        //用户可以添加咨询
        ImmigrationServices iImmigrationServicesService = BeanUtil.copyProperties(immigrationServicesDto, ImmigrationServices.class);
        boolean flag = save(iImmigrationServicesService);
        int status = flag? Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = flag?"添加成功":"添加失败";
        return new Result(status,msg);
    }

    @Override
    public Result selectByUser(Long id) {
        //根据用户ID查询咨询表
        List<ImmigrationServices> list = lambdaQuery().eq(ImmigrationServices::getUserId, id).list();
        int status = list!=null? Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = list!=null?"查询成功":"查询失败";
        return new Result(status,msg,list);
    }

    @Override
    public Result selectByImmigration(Long id) {
        //根据律师userid查询对应的律师ID
        ImmigrationLawyers lawyers = service.lambdaQuery().eq(ImmigrationLawyers::getUserId, id).one();
        if(BeanUtil.isEmpty(lawyers)){
            return new Result(Code.SELECT_ERROR,"查询律师为空");
        }
        //根据律师ID查询对应的咨询表
        List<ImmigrationServices> list = lambdaQuery().eq(ImmigrationServices::getLawyerId, lawyers.getId()).list();
        int status = list!=null? Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = list!=null?"查询成功":"查询失败";
        return new Result(status,msg,list);
    }

    @Override
    public Result updateByUser(ImmigrationDto immigrationDto) {
        //根据咨询表ID修改对应的咨询表
        ImmigrationServices immigrationServices = BeanUtil.copyProperties(immigrationDto, ImmigrationServices.class);
        immigrationServices.setLastUpdated(LocalDateTime.now());
        boolean flag = updateById(immigrationServices);
        int status = flag? Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = flag?"修改成功":"修改失败";
        return new Result(status,msg);
    }

    @Override
    public Result deleteById(long id) {
        //超级管理员删除咨询表
        boolean flag = removeById(id);
        int status = flag? Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = flag?"删除成功":"删除失败";
        return new Result(status,msg);
    }

    @Override
    public Result selectAllImmigration() {
        List<ImmigrationServices> list = list();
        int status = list!=null? Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = list!=null?"查询成功":"查询失败";
        return new Result(status,msg,list);
    }

    @Override
    public Result updateImmigration(ImmigrationServices immigrationServices) {
        immigrationServices.setLastUpdated(LocalDateTime.now());
        boolean flag = updateById(immigrationServices);
        int status = flag? Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = flag?"修改成功":"修改失败";
        return new Result(status,msg);
    }

    @Override
    public Result insertImmigration(ImmigrationServices immigrationServices) {
        boolean flag = save(immigrationServices);
        int status = flag? Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = flag?"添加成功":"添加失败";
        return new Result(status,msg);
    }
}
