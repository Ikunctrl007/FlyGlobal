package com.nnxx.service.impl;

import com.nnxx.domain.Code;
import com.nnxx.domain.Result;
import com.nnxx.domain.po.Universities;
import com.nnxx.mapper.UniversitiesMapper;
import com.nnxx.service.IUniversitiesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nnxx.util.ImagesUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 院校信息表 服务实现类
 * </p>
 *
 * @author 宁x
 * @since 2024-10-23
 */
@Service
public class UniversitiesServiceImpl extends ServiceImpl<UniversitiesMapper, Universities> implements IUniversitiesService {

    @Override
    public Result selectAll() {
        List<Universities> list = list();
        int status = list!=null? Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = list!=null?"查询成功":"查询失败";
        return new Result(status,msg,list);
    }

    @Override
    public Result selectByName(String collegeName) {
        List<Universities> list = lambdaQuery().like(collegeName != null, Universities::getCollegeName, "college_name").list();
        int status = list!=null? Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = list!=null?"查询成功":"查询失败";
        return new Result(status,msg,list);
    }

    @Override
    public Result insert(Universities universities) {
        boolean flag = save(universities);
        int status = flag? Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = flag?"添加成功":"添加失败";
        return new Result(status,msg);
    }

    @Override
    public Result updateByCollegeId(Universities universities) {
        boolean flag = updateById(universities);
        //删除旧图片
        if(universities.getOldCollegeImg()!=null) {
            ImagesUtils.deleteImage(universities.getOldCollegeImg());
        }
        int status = flag? Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = flag?"修改成功":"修改失败";
        return new Result(status,msg);
    }

    @Override
    public Result deleteById(Long id) {
        Universities universities = getById(id);
        if(universities.getOldCollegeImg()!=null) {
            ImagesUtils.deleteImage(universities.getOldCollegeImg());
        }
        if(universities.getCollegeImg()!=null) {
            ImagesUtils.deleteImage(universities.getOldCollegeImg());
        }
        boolean flag = removeById(id);
        int status = flag? Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = flag?"删除成功":"删除失败";
        return new Result(status,msg);
    }
}
