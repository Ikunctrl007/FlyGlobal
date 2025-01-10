package com.nnxx.service.impl;

import com.nnxx.domain.Code;
import com.nnxx.domain.Result;
import com.nnxx.domain.po.ImmigrationLawyers;
import com.nnxx.mapper.ImmigrationLawyersMapper;
import com.nnxx.service.IImmigrationLawyersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 移民律师表 服务实现类
 * </p>
 *
 * @author 宁x
 * @since 2024-10-23
 */
@Service
public class ImmigrationLawyersServiceImpl extends ServiceImpl<ImmigrationLawyersMapper, ImmigrationLawyers> implements IImmigrationLawyersService {

    @Override
    public Result insertOne(ImmigrationLawyers immigrationLawyers) {
        //添加留学顾问
        boolean flag = save(immigrationLawyers);
        int status = flag? Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = flag?"添加成功":"添加失败";
        return new Result(status,msg);
    }

    @Override
    public Result updateOne(ImmigrationLawyers immigrationLawyers) {
        //修改留学顾问
        boolean flag = updateById(immigrationLawyers);
        int status = flag? Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = flag?"修改成功":"修改失败";
        return new Result(status,msg);
    }

    @Override
    public Result delete(Integer id) {
        //超级管理员删除留学顾问
        boolean flag = removeById(id);
        int status = flag? Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = flag?"删除成功":"删除失败";
        return new Result(status,msg);
    }

    @Override
    public Result selectOne(Long id) {
        //用户自己查询留学顾问
        ImmigrationLawyers immigrationLawyers = query().eq("user_id",id).one();
        int status = immigrationLawyers!=null? Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = immigrationLawyers!=null?"查询成功":"查询失败";
        return new Result(status,msg,immigrationLawyers);
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
