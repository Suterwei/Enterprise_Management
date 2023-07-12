package com.project1.springboot.controller;

import com.project1.springboot.entity.Announcement;
import com.project1.springboot.mapper.AnnouncementMapper;
import com.project1.springboot.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/announcement")
public class AnnouncementController {

    @Autowired
    private AnnouncementMapper announcementMapper;

    @Autowired
    private AnnouncementService announcementService;

    //新增和修改
    @PostMapping
    public Integer save(@RequestBody Announcement announcement) {
        //新增或者更新
        return announcementService.save(announcement);
    }

    //查询所有数据
    @GetMapping
    public List<Announcement> findAll() {
        List<Announcement> all = announcementMapper.findAll();
        return all;
    }

    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id) {
        return announcementMapper.deleteById(id);
    }

    //分页查询接口
    //@RequestParam接受 ？pageNum=1&pageSize=10
    //limit第一个参数=（pageNum-1）*pageSize
    //pageSize
    @GetMapping("/{page}")
    public Map<String, Object> findPage(@RequestParam Integer pageNum,
                                        @RequestParam Integer pageSize,
                                        @RequestParam String name
    ) {
        pageNum = (pageNum-1) * pageSize;
        name = '%' + name + '%';
        List<Announcement> data = announcementMapper.selectPage(pageNum,pageSize,name);
        Integer total = announcementMapper.selectTotal(name);
        Map<String, Object> res = new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }
}
