package com.project1.springboot.mapper;

import com.project1.springboot.entity.Login;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LoginMapper {

    @Select("select * from login where name = #{name}")
    Login findByUsername(String name);

}
