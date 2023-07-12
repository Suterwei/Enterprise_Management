package com.project1.springboot.mapper;

import com.project1.springboot.entity.Permissions;
import org.apache.ibatis.annotations.*;

import java.util.List;

//private Integer id;
//private String name;
//private Integer num;
//private String descri;
//private String time;

@Mapper
public interface PermissionsMapper {

    @Select("select *from official")
    List<Permissions> findAll();

    @Insert("insert into official(name,num,descri,time) values(#{name},#{num},#{descri},#{time})")
    int insert(Permissions permissions);

    @Update("update official set name=#{name},num=#{num},descri=#{descri},time=#{time} where id=#{id}")
    int update(Permissions permissions);

    @Delete("delete from official where id = #{id}")
    Integer deleteById(@Param("id") Integer id);

    @Select("select *from official where name like #{name} limit #{pageNum},#{pageSize}")
    List<Permissions> selectPage(Integer pageNum, Integer pageSize, String name);

    @Select("select count(*) from official where name like #{name}")
    Integer selectTotal(String name);
}
