package com.lcl.hw.mapper;

import com.lcl.hw.domain.UserInfo;

/**
 * Created by Rain on 2016/12/15 8:36.
 */
public interface UserInfoMapper {
    public UserInfo findByUserId(String userId);
}
