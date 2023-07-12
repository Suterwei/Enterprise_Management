package com.project1.springboot.mapper;

import com.project1.springboot.entity.Announcement;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AnnouncementMapper {

    @Select("select * from announcement")
    List<Announcement> findAll();

    @Insert("insert into announcement(id,title,name,ctime,category,receiving) values(#{id},#{title},#{name},#{ctime},#{category},#{receiving})")
    int insert(Announcement announcement);

    @Update("update announcement set title=#{title},name=#{name},ctime=#{ctime},category=#{category},receiving=#{receiving} where id=#{id}")
    int update(Announcement announcement);

    @Delete("delete from announcement where id=#{id}")
    Integer deleteById(@Param("id") Integer id);

    @Select("select *from announcement where name like #{name} limit #{pageNum},#{pageSize}")
    List<Announcement> selectPage(Integer pageNum, Integer pageSize,String name);

//    @Select("select *from announcement where name like #{name} and department like #{department} and position like #{position} limit #{pageNum},#{pageSize}")
//    List<Announcement> selectPage(Integer pageNum, Integer pageSize, String name , String department, String position);

    @Select("select count(*) from announcement where name like #{name}")
    Integer selectTotal(String name);
}
