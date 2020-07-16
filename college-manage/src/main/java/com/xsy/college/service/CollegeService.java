package com.xsy.college.service;

import com.xsy.college.pojo.College;

import java.util.List;

/**
 * Created by Administrator on 2020/7/9.
 */
public interface CollegeService {

    public List<College> getList();


    public boolean addCollege(College college);
}
