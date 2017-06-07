package com.template.batis.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * Created by jylee on 2017-06-05.
 */
public interface TestMapper {
    String getName();
    void updateName(@Param("id")int id, @Param("name")String name);
}
