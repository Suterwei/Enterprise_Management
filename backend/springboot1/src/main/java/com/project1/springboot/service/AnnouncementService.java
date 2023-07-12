package com.project1.springboot.service;

import com.project1.springboot.entity.Announcement;
import com.project1.springboot.mapper.AnnouncementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnouncementService {

    @Autowired
    private AnnouncementMapper announcementMapper;

    public int save(Announcement announcement) {
        if (announcement.getId() == null) {
            return announcementMapper.insert(announcement);
        } else {
            return announcementMapper.update(announcement);
        }
    }
}
