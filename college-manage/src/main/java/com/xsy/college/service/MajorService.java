package com.xsy.college.service;

import com.xsy.college.pojo.Major;
import com.xsy.college.pojo.Page;

import java.util.List;

/**
 * Created by Administrator on 2020/7/9.
 */
public interface MajorService {
    public Major getById(int id);
    public boolean add(Major major);
    public boolean update(Major major);
    public boolean delete(int mid);

    public List<Major> getAll();
    public List<Major> getList(Integer cid);

    public Page<Major> getAll(Major major,int pageNo,int limit);
}
