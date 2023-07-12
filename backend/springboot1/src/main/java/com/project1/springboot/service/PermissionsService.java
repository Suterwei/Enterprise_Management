package com.project1.springboot.service;

import com.project1.springboot.entity.Permissions;
import com.project1.springboot.mapper.PermissionsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionsService {

    @Autowired
    private PermissionsMapper permissionsMapper;

    public int save(Permissions permissions) {
        if(permissions.getId() == null) {
            return permissionsMapper.insert(permissions);
        }else {
            return permissionsMapper.update(permissions);
        }
    }
}

