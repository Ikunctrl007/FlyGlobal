package com.nnxx.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.nnxx.domain.Code;
import com.nnxx.domain.Result;
import com.nnxx.domain.po.ImmigrationLawyers;
import com.nnxx.domain.po.Users;
import com.nnxx.domain.po.VisaOfficers;
import com.nnxx.domain.vo.OfficersInformationVo;
import com.nnxx.mapper.VisaOfficersMapper;
import com.nnxx.service.IUsersService;
import com.nnxx.service.IVisaOfficersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 签证官员表 服务实现类
 * </p>
 *
 * @author 宁x
 * @since 2024-10-23
 */
@Service
public class VisaOfficersServiceImpl extends ServiceImpl<VisaOfficersMapper, VisaOfficers> implements IVisaOfficersService {
    @Autowired
    private IUsersService service;
    @Override
    public Result insertOne(VisaOfficers visaOfficers) {
        //添加签证官员
        boolean flag = save(visaOfficers);
        int status = flag? Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = flag?"添加成功":"添加失败";
        return new Result(status,msg);
    }

    @Override
    public Result updateOne(VisaOfficers visaOfficers) {
        //修改签证官员
        boolean flag = updateById(visaOfficers);
        int status = flag? Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = flag?"修改成功":"修改失败";
        return new Result(status,msg);
    }

    @Override
    public Result delete(Integer id) {
        //超级管理员删除签证官员
        boolean flag = removeById(id);
        int status = flag? Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = flag?"删除成功":"删除失败";
        return new Result(status,msg);
    }

    @Override
    public Result selectOne(Long id) {
        //用户自己查询签证官员
        VisaOfficers visaOfficers =  query().eq("user_id",id).one();
        int status = visaOfficers!=null? Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = visaOfficers!=null?"查询成功":"查询失败";
        Users users = service.getById(id);
        OfficersInformationVo officersInformationVo = new OfficersInformationVo();
        BeanUtil.copyProperties(users, officersInformationVo);
        BeanUtil.copyProperties(visaOfficers, officersInformationVo);

        return new Result(status,msg,officersInformationVo);
    }

    @Override
    public Result selectAll() {
        //超级管理员查询所有的用户
        List<VisaOfficers> list = list();
        int status = list!=null? Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = list!=null?"查询成功":"查询失败";
        return new Result(status,msg,list);
    }
}
