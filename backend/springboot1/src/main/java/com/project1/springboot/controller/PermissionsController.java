package com.project1.springboot.controller;

import com.project1.springboot.entity.Permissions;
import com.project1.springboot.mapper.PermissionsMapper;
import com.project1.springboot.service.PermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/permissions")
public class PermissionsController {

    @Autowired
    private PermissionsMapper permissionsMapper;

    @Autowired
    private PermissionsService permissionsService;

    //新增和修改
    @PostMapping
    public Integer save(@RequestBody Permissions permissions) {
        //新增或者更新
        return permissionsService.save(permissions);
    }

    //查询所有数据
    @GetMapping
    public List<Permissions> findAll() {
        List<Permissions> all = permissionsMapper.findAll();
        return all;
    }

    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id) {
        return permissionsMapper.deleteById(id);
    }

    //分页查询接口
    //@RequestParam接受 ？pageNum=1&pageSize=10
    //limit第一个参数=（pageNum-1）*pageSize
    //pageSize
    @GetMapping("/{page}")
    public Map<String, Object> findPage(@RequestParam(required=false) Integer pageNum,
                                        @RequestParam(required=false) Integer pageSize,
                                        @RequestParam(required=false) String name) {
        pageNum = (pageNum-1) * pageSize;
        name = "%" + name + "%";
        List<Permissions> data = permissionsMapper.selectPage(pageNum,pageSize,name);
        Integer total = permissionsMapper.selectTotal(name);
        Map<String, Object> res = new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }
}
