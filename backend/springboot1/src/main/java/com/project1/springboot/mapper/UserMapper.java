package com.project1.springboot.mapper;

import com.project1.springboot.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select *from employee")
    List<User> findAll();

    @Insert("insert into employee(name,sex,department,position,phone,states) values(#{name},#{sex},#{department},#{position},#{phone},#{states})")
    int insert(User user);

    @Update("update employee set name=#{name},sex=#{sex},department=#{department},position=#{position},phone=#{phone},states=#{states} where id=#{id}")
    int update(User user);

    @Delete("delete from employee where id = #{id}")
    Integer deleteById(@Param("id") Integer id);

    @Select("select *from employee where name like #{name} and department like #{department} and position like #{position} limit #{pageNum},#{pageSize}")
    List<User> selectPage(Integer pageNum, Integer pageSize, String name , String department, String position);

    @Select("select count(*) from employee where name like #{name} and department like #{department} and position like #{position}")
    Integer selectTotal(String name,String department,String position);
}
