package com.lcl.hw.services;

import com.lcl.hw.domain.Register;

/**
 * Created by Rain on 2016/12/13 18:44.
 */
public interface TestService {
    public Register findById(String loginid) throws Exception;
}
