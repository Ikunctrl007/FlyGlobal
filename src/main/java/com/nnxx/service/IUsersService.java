package com.nnxx.service;

import com.nnxx.domain.Result;
import com.nnxx.domain.dto.PagesDto;
import com.nnxx.domain.dto.UsersDto;
import com.nnxx.domain.po.Users;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author 宁x
 * @since 2024-10-23
 */
public interface IUsersService extends IService<Users> {

    Result insert(UsersDto usersDto);

    Result selectAll(PagesDto pagesDto);

    Result selectOne(Long id);

    Result updateOne(Long id, UsersDto usersDto);

    Result updateAdmin(Users users);

    Result deleteId(int id);

    Result selectByRoleType(int roleType);
}
