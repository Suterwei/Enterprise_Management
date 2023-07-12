package com.project1.springboot.controller;

import com.project1.springboot.entity.User;
import com.project1.springboot.mapper.UserMapper;
import com.project1.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    //新增和修改
    @PostMapping
    public Integer save(@RequestBody User user) {
        //新增或者更新
        return userService.save(user);
    }

    //查询所有数据
    @GetMapping
    public List<User> findAll() {
        List<User> all = userMapper.findAll();
        return all;
    }

    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id) {
        return userMapper.deleteById(id);
    }

    //分页查询接口
    //@RequestParam接受 ？pageNum=1&pageSize=10
    //limit第一个参数=（pageNum-1）*pageSize
    //pageSize
    @GetMapping("/{page}")
    public Map<String, Object> findPage(@RequestParam Integer pageNum,
                                        @RequestParam Integer pageSize,
                                        @RequestParam String name,
                                        @RequestParam String department,
                                        @RequestParam String position) {
        pageNum = (pageNum-1) * pageSize;
        name = "%" + name + "%";
        department = '%' + department + '%';
        position = '%' + position + '%';
        List<User> data = userMapper.selectPage(pageNum,pageSize,name,department,position);
        Integer total = userMapper.selectTotal(name,department,position);
        Map<String, Object> res = new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }
}
