package com.nnxx.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.nnxx.domain.Code;
import com.nnxx.domain.Result;
import com.nnxx.domain.po.ImmigrationLawyers;
import com.nnxx.domain.po.Users;
import com.nnxx.domain.vo.AdvisorsInformationVo;
import com.nnxx.domain.vo.LawyersInformationVo;
import com.nnxx.mapper.ImmigrationLawyersMapper;
import com.nnxx.service.IImmigrationLawyersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nnxx.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 移民咨询表 服务实现类
 * </p>
 *
 * @author 宁x
 * @since 2024-10-23
 */
@Service
public class ImmigrationLawyersServiceImpl extends ServiceImpl<ImmigrationLawyersMapper, ImmigrationLawyers> implements IImmigrationLawyersService {
    @Autowired
    private IUsersService service;
    @Override
    public Result insertOne(ImmigrationLawyers immigrationLawyers) {
        //添加移民咨询
        boolean flag = save(immigrationLawyers);
        int status = flag? Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = flag?"添加成功":"添加失败";
        return new Result(status,msg);
    }

    @Override
    public Result updateOne(ImmigrationLawyers immigrationLawyers) {
        //修改移民咨询
        boolean flag = updateById(immigrationLawyers);
        int status = flag? Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = flag?"修改成功":"修改失败";
        return new Result(status,msg);
    }

    @Override
    public Result delete(Integer id) {
        //超级管理员删除移民咨询
        boolean flag = removeById(id);
        int status = flag? Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = flag?"删除成功":"删除失败";
        return new Result(status,msg);
    }

    @Override
    public Result selectOne(Long id) {
        //用户自己查询移民咨询
        ImmigrationLawyers immigrationLawyers = query().eq("user_id",id).one();
        Users users = service.getById(id);
        LawyersInformationVo lawyersInformationVo = new LawyersInformationVo();
        BeanUtil.copyProperties(users, lawyersInformationVo);
        BeanUtil.copyProperties(immigrationLawyers, lawyersInformationVo);

        int status = immigrationLawyers!=null? Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = immigrationLawyers!=null?"查询成功":"查询失败";
        return new Result(status,msg,lawyersInformationVo);
    }

    @Override
    public Result selectAll() {
        //超级管理员查询所有的用户
        List<ImmigrationLawyers> list = list();
        int status = list!=null? Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = list!=null?"查询成功":"查询失败";
        return new Result(status,msg,list);
    }
}
