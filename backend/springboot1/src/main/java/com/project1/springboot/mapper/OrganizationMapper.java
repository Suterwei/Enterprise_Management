package com.project1.springboot.mapper;

import com.project1.springboot.entity.Organization;
import com.project1.springboot.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrganizationMapper {

    @Select("select * from organization")
    List<Organization> findAll();

    @Insert("insert into organization(department,num,charge,descri,states) values(#{department},#{num},#{charge},#{descri},#{states})")
    int insert(Organization organization);

    @Update("update organization set department=#{department},num=#{num},charge=#{charge},descri=#{descri},states=#{states} where id=#{id}")
    int update(Organization organization);

    @Delete("delete from organization where id=#{id}")
    Integer deleteById(@Param("id") Integer id);


    @Select("select * from organization where department like #{department} and charge like #{charge} and descri like #{descri} limit #{pageNum},#{pageSize}")
    List<Organization> selectPage(Integer pageNum, Integer pageSize, String department , String charge, String descri);

    @Select("select count(*) from organization where department like #{department} and charge like #{charge} and descri like #{descri}")
    Integer selectTotal(String department,String charge,String descri);
}
