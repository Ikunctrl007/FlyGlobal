package com.nnxx.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nnxx.domain.Code;
import com.nnxx.domain.Result;
import com.nnxx.domain.dto.PagesDto;
import com.nnxx.domain.dto.UsersDto;
import com.nnxx.domain.po.PagesVo;
import com.nnxx.domain.po.Users;
import com.nnxx.domain.vo.UsersVo;
import com.nnxx.exception.BusinessException;
import com.nnxx.mapper.UsersMapper;
import com.nnxx.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author 宁x
 * @since 2024-10-23
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

    @Override
    public Result insert(UsersDto usersDto) {
        if(Objects.isNull(usersDto)){
            return new Result(Code.SELECT_ERROR,"输入不能为空");
        }
        //查询用户名是否存在，存在返回提示
        List<Users> list = list();
        list.forEach(users -> {
            if(Objects.equals(users.getUsername(), usersDto.getUsername())){
                throw new  BusinessException(Code.SELECT_ERROR,"用户名已存在，请重新输入用户名");
            }
        });
        Users users = BeanUtil.copyProperties(usersDto,Users.class);
        //使用Security提供的加密方法来加密密码
        BCryptPasswordEncoder bCryptPasswordEncoder =new BCryptPasswordEncoder();
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        boolean flag = save(users);
        int status = flag?Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = flag?"注册成功":"注册失败";
        return new Result(status,msg);
    }

    @Override
    public Result selectAll(PagesDto pagesDto) {
        //根据分页查询用户信息
        Page<Users> page = new Page<>(pagesDto.getPage(), pagesDto.getSize());
        page.addOrder(new OrderItem(pagesDto.getSortBy(),pagesDto.isAsc()));
        lambdaQuery().page(page);
        //如果查询总条数为0，则直接返回查询失败
        if (page.getTotal()==0){
            return new Result(Code.SELECT_ERROR,"查询失败");
        }
        PagesVo<Users> usersPagesVo = new PagesVo<>(page.getTotal(),page.getPages(),page.getRecords());
        return new Result(Code.SELECT_YES,"查询成功",usersPagesVo);
    }

    @Override
    public Result selectOne(Long id) {
        //根据用户id查询用户信息
        Users users = getById(id);
        if (Objects.isNull(users)){
            return new Result(Code.SELECT_ERROR,"查询失败");
        }
        UsersVo usersVo = BeanUtil.copyProperties(users, UsersVo.class);
        return new Result(Code.SELECT_YES,"查询成功",usersVo);
    }

    @Override
    public Result updateOne(Long id, UsersDto usersDto) {
        //将Dto对象转换成Users对象
        Users users = BeanUtil.copyProperties(usersDto,Users.class);
        users.setId(id);
        //普通用户不可以修改角色
        if (!Objects.isNull(users.getRoleId())){
            users.setRoleId(null);
        }
        //执行修改
        boolean flag = updateById(users);
        int status = flag?Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = flag?"修改成功":"修改失败";
        return new Result(status,msg);
    }

    @Override
    public Result updateAdmin(Users users) {
        boolean flag = updateById(users);
        int status = flag?Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = flag?"修改成功":"修改失败";
        return new Result(status,msg);
    }

    @Override
    public Result deleteId(int id) {
        boolean flag = removeById(id);
        int status = flag?Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = flag?"删除成功":"删除失败";
        return new Result(status,msg);
    }

    @Override
    public Result selectByRoleType(int roleType) {
        List<Users> list = lambdaQuery().eq(Users::getRoleId, roleType).list();
        int status = list!=null?Code.SELECT_YES:Code.SELECT_ERROR;
        String msg = list!=null?"查询成功":"查询失败";
        return new Result(status,msg,list);
    }
}
