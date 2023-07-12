package com.project1.springboot.service;

import com.project1.springboot.entity.Organization;
import com.project1.springboot.mapper.OrganizationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project1.springboot.entity.User;
import com.project1.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationMapper organizationMapper;

    public int save(Organization organization) {
        if(organization.getId() == null) {
            return organizationMapper.insert(organization);
        }else {
            return organizationMapper.update(organization);
        }
    }
}

