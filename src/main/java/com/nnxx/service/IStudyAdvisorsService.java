package com.nnxx.service;

import com.nnxx.domain.Result;
import com.nnxx.domain.po.StudyAdvisors;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 留学顾问表 服务类
 * </p>
 *
 * @author 宁x
 * @since 2024-10-23
 */
public interface IStudyAdvisorsService extends IService<StudyAdvisors> {

    Result insertOne(StudyAdvisors studyAdvisors);

    Result updateOne(StudyAdvisors studyAdvisors);

    Result delete(Integer id);

    Result selectOne(Integer id);

    Result selectAll();
}
