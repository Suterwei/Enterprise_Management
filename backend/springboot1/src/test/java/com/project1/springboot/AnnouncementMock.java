package com.project1.springboot;

import java.util.Random;

public class AnnouncementMock {

    public static Random r = new Random();

    public static Integer randomId() { return r.nextInt(99999); }

    public static final String[] title = {"如何处理好和客户的关系", "关于公司的各项规定", "员工体检说明",
            "坚决抵制加班说明", "发放工资说明", "如何培训实习生", "关于密训的简介", "不强制打卡", "关于五险一金", "关于生活保障"};

    public static String randomTitle() {
        return title[r.nextInt(title.length)];
    }

    public static final String[] category = {"内部分享", "政策法规", "公司说明", "员工说明", "生活说明"};

    public static String randomCategory() {
        return category[r.nextInt(category.length)];
    }

    public static final String[] receiving = {"全体员工", "开发部成员", "设计部成员", "生活部成员",
            "财务部成员", "人事部成员", "计划部成员", "营销部成员", "安全部成员", "监察部成员", "后勤部成员", "保卫部成员"};

    public static String randomReceiving() {
        return receiving[r.nextInt(receiving.length)];
    }

    public static String[] firstname = {"胡", "吴", "杨", "王", "朱", "苏", "童", "贺", "李", "陈", "原", "农", "使", "蔡"};

    public static String[] lastname = {"一一", "二", "三三", "四", "五五", "六", "柒柒", "八", "九九", "十", "只因", "者", "神"};

    public static String randomFirstName() {return firstname[r.nextInt(firstname.length)];}

    public static String randomLastName() {return lastname[r.nextInt(lastname.length)];}

    public static String randomName() {return firstname[r.nextInt(firstname.length)]+lastname[r.nextInt(lastname.length)];}
}
