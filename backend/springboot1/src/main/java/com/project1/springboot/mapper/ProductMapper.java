package com.project1.springboot.mapper;

import com.project1.springboot.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;//Product

@Mapper//表名 products
public interface ProductMapper {

    @Select("select *from products")
    List<Product> findAll();

    @Insert("insert into products(name,price,num,norm,state) values(#{name},#{price},#{num},#{norm},#{state})")
    int insert(Product product);

    @Update("update products set name=#{name},price=#{price},norm=#{norm},num=#{num},state=#{state} where id=#{id}")
    int update(Product product);

    @Delete("delete from products where id = #{id}")
    Integer deleteById(@Param("id") Integer id);

    @Select("select *from products where name like #{name} and state like #{state} limit #{pageNum},#{pageSize}")
    List<Product> selectPage(Integer pageNum, Integer pageSize, String name , String state);

    @Select("select count(*) from products where name like #{name} and state like #{state}")
    Integer selectTotal(String name,String state);
}
