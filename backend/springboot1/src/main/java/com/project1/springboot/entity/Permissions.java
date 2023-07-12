package com.project1.springboot.entity;

import lombok.Data;

@Data
public class Permissions {

    private Integer id;//编号（前端不显示）
    private String name;//职务名称
    private String num;//成员数量
    private String descri;//职务描述
    private String time;//更新时间

}