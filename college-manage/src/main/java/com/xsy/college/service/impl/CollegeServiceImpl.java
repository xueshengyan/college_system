package com.xsy.college.service.impl;

import com.xsy.college.mapper.CollegeMapper;
import com.xsy.college.pojo.College;
import com.xsy.college.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2020/7/9.
 */
@Service
public class CollegeServiceImpl implements CollegeService{

    @Autowired
    CollegeMapper collegeMapper;

    @Override
    public List<College> getList() {
        return collegeMapper.selectAll();
    }

    @Override
    public boolean addCollege(College college) {
        return collegeMapper.insertSelective(college)>0 ? true:false;
    }
}
