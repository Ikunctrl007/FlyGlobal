package com.nnxx.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.nnxx.domain.Code;
import com.nnxx.domain.Result;
import com.nnxx.domain.po.StudyAdvisors;
import com.nnxx.domain.po.Users;
import com.nnxx.domain.vo.AdvisorsInformationVo;
import com.nnxx.mapper.StudyAdvisorsMapper;
import com.nnxx.service.IStudyAdvisorsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nnxx.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 留学顾问表 服务实现类
 * </p>
 *
 * @author 宁x
 * @since 2024-10-23
 */
@Service
public class StudyAdvisorsServiceImpl extends ServiceImpl<StudyAdvisorsMapper, StudyAdvisors> implements IStudyAdvisorsService {

    @Autowired
    private IUsersService service;
    @Override
    public Result insertOne(StudyAdvisors studyAdvisors) {
        //添加留学顾问
        boolean flag = save(studyAdvisors);
        int status = flag? Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = flag?"添加成功":"添加失败";
        return new Result(status,msg);
    }

    @Override
    public Result updateOne(StudyAdvisors studyAdvisors) {
        //修改留学顾问
        boolean flag = updateById(studyAdvisors);
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
        StudyAdvisors studyAdvisors = query().eq("user_id",id).one();
        Users users = service.getById(id);
        AdvisorsInformationVo advisorsInformationVo = new AdvisorsInformationVo();
        BeanUtil.copyProperties(users, advisorsInformationVo);
        BeanUtil.copyProperties(studyAdvisors, advisorsInformationVo);

        int status = users!=null? Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = users!=null?"查询成功":"查询失败";
        return new Result(status,msg,advisorsInformationVo);
    }

    @Override
    public Result selectAll() {
        //超级管理员查询所有的用户
        List<StudyAdvisors> list = list();
        int status = list!=null? Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = list!=null?"查询成功":"查询失败";
        return new Result(status,msg,list);
    }
}
