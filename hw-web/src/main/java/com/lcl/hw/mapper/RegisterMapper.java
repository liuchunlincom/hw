package com.lcl.hw.mapper;

import com.lcl.hw.domain.Register;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.Mapping;

/**
 * Created by Rain on 2016/12/15 8:36.
 */
public interface RegisterMapper {
    public Register findByLoginid(String loginId);
}
