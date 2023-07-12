package com.project1.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class User {
//    private Integer id;
//    private String username;
    //如果不希望看见密码，则加
    //@JsonIgnore
//    private String password;
//    private String nickname;
//    private String email;
//    private String phone;
//    private String address;
    private Integer id;
    private String name;
    private String sex;
    private String department;
    private String position;
    private String phone;
    private String states;

}