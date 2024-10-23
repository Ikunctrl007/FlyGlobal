package com.nnxx.service;


import com.nnxx.domain.Result;
import com.nnxx.domain.po.Users;

public interface LoginService {
    Result login(Users user);

}
