package com.project1.springboot.entity;

import lombok.Data;

@Data
public class Announcement {

    private Integer id; //公告编号（新添的，方便查询等操作）
    private String title; //公告标题
    private String name; //发布人
    private String ctime; //发布时间
    private String category; //所属栏目
    private String receiving; //接收人员
}
