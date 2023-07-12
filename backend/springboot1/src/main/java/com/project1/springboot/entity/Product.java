package com.project1.springboot.entity;

import lombok.Data;
@Data
public class Product {

    private Integer id;//产品编号
    private String name;//产品名称
    private String price;//sex 产品单价
    private String num;//position 库存数量
    private String norm;//department 产品规格
    private String state;//phone 上架状态
}
