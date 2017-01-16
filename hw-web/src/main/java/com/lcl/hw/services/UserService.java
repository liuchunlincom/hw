package com.lcl.hw.services;

import com.lcl.hw.domain.Register;
import com.lcl.hw.utils.RetObj;

/**
 * Created by Rain on 2016/12/22 19:24.
 */
public interface UserService {
    public RetObj login(Register register) throws Exception;
}
