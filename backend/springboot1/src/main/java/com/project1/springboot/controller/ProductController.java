package com.project1.springboot.controller;

import com.project1.springboot.entity.Product;
import com.project1.springboot.mapper.ProductMapper;
import com.project1.springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
//product
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductService productService;

    //新增和修改
    @PostMapping
    public Integer save(@RequestBody Product product) {
        //新增或者更新
        return productService.save(product);
    }

    //查询所有数据
    @GetMapping
    public List<Product> findAll() {
        List<Product> all = productMapper.findAll();
        return all;
    }

    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id) {
        return productMapper.deleteById(id);
    }

    //分页查询接口
    //@RequestParam接受 ？pageNum=1&pageSize=10
    //limit第一个参数=（pageNum-1）*pageSize
    //pageSize
    @GetMapping("/{page}")
    public Map<String,Object> findPage(@RequestParam Integer pageNum,
                                       @RequestParam Integer pageSize,
                                       @RequestParam (required=false) String name,
                                       @RequestParam (required=false) String state) {
        pageNum = (pageNum-1) * pageSize;
        name = '%'+ name + '%';
        state = '%' + state + '%';
        List<Product> data = productMapper.selectPage(pageNum,pageSize,name,state);
        Integer total = productMapper.selectTotal(name,state);
        Map<String, Object> res = new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }
}
