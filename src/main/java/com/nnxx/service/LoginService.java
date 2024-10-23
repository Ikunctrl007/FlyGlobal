package com.nong.service;


import com.nong.domain.Result;
import com.nong.domain.UserInformation;

public interface LoginService {
    Result login(UserInformation user);

    Result logout();
}
