package com.caoyang2002.qoobk.mapper;

import com.caoyang2002.qoobk.pojo.vo.UserVO;

public interface UserMapper {
    UserVO selectByUsername(String username);
}
