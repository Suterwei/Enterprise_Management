package com.project1.springboot.controller;

import com.project1.springboot.entity.Organization;
//import com.project1.springboot.entity.User;
import com.project1.springboot.mapper.OrganizationMapper;
import com.project1.springboot.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/organization")
public class OrganizationController {

    @Autowired
    private OrganizationMapper organizationMapper;

    @Autowired
    private OrganizationService organizationService;

    //新增和修改
    @PostMapping
    public Integer save(@RequestBody Organization organization) {
        //新增或者更新
        return organizationService.save(organization);
    }

    //查询所有数据
    @GetMapping
    public List<Organization> findAll() {
        List<Organization> all = organizationMapper.findAll();
        return all;
    }

    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id) {
        return organizationMapper.deleteById(id);
    }

    //分页查询接口
    //@RequestParam接受 ？pageNum=1&pageSize=10
    //limit第一个参数=（pageNum-1）*pageSize
    //pageSize
    @GetMapping("/{page}")
    public Map<String, Object> findPage(@RequestParam Integer pageNum,
                                        @RequestParam Integer pageSize,
                                        @RequestParam String department,
                                        @RequestParam String charge,
                                        @RequestParam String descri) {
        pageNum = (pageNum-1) * pageSize;
        department = "%" + department + "%";
        charge = '%' + charge + '%';
        descri = '%' + descri + '%';
        List<Organization> data = organizationMapper.selectPage(pageNum,pageSize,department,charge,descri);
        Integer total = organizationMapper.selectTotal(department,charge,descri);
        Map<String, Object> res = new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }
}
