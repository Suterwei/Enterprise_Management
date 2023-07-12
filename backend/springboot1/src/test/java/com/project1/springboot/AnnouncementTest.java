package com.project1.springboot;

import com.project1.springboot.controller.AnnouncementController;
import com.project1.springboot.entity.Announcement;
import com.project1.springboot.mapper.AnnouncementMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@SpringBootTest
class AnnouncementTest {

    @Autowired
    AnnouncementMapper announcementMapper;

    @Autowired
    AnnouncementController announcementController;

    public void generateAnnouncements(int n){
        for (int i = 0; i < n; i++) {
            Announcement a = new Announcement();
            a.setId(AnnouncementMock.randomId());
            a.setTitle(AnnouncementMock.randomTitle());
            a.setName(AnnouncementMock.randomName());
            Date nowTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            a.setCtime(formatter.format(nowTime));
            a.setCategory(AnnouncementMock.randomCategory());
            a.setReceiving(AnnouncementMock.randomReceiving());
            announcementController.save(a);
            announcementMapper.insert(a);
        }

    }

    //新增公告
    @Test
    void addAnnouncements(){generateAnnouncements(100);}

    //根据id删除公告
    @Test
    void deleteAnnouncement(){announcementMapper.deleteById(1111);}

    //查询并导出员工信息，存放到AnnouncementInformation.txt文件中
    @Test
    public void testSelectAnnouncements() throws FileNotFoundException, UnsupportedEncodingException {

        // 这里我们使用相对路径
        File outfile = new File("AnnouncementInformation.txt");

        PrintWriter out = new PrintWriter(outfile, "UTF-8");

        List<Announcement> a = announcementMapper.findAll();
        out.println("查询到" + a.size() + "条公告信息");
        out.println("-------------------------------");
        for (int i = 0; i < a.size(); i++)
        {
            out.println(a.get(i).getId());
            out.println(a.get(i).getTitle());
            out.println(a.get(i).getName());
            out.println(a.get(i).getCtime());
            out.println(a.get(i).getCategory());
            out.println(a.get(i).getReceiving());
            out.println("===============================");
        }

        // 释放资源
        out.close();
    }

}
