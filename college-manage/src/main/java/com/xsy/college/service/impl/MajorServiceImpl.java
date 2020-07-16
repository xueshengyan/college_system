package com.xsy.college.service.impl;

import com.github.pagehelper.PageHelper;
import com.xsy.college.mapper.MajorMapper;
import com.xsy.college.pojo.Major;
import com.xsy.college.pojo.Page;
import com.xsy.college.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by Administrator on 2020/7/9.
 */
@Service
public class MajorServiceImpl implements MajorService{

    @Autowired
    private MajorMapper majorMapper;

    @Override
    public Major getById(int id) {
        //根据主键进行查询，必须保证结果唯一
        return majorMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean add(Major major) {
        //插入一条数据,只插入不为null的字段,不会影响有默认值的字段
        int count= majorMapper.insertSelective(major);
        return  count>0 ? true:false;
    }

    @Override
    public boolean update(Major major) {
        //根据主键进行更新
        //只会更新不是null的数据
        int count = majorMapper.updateByPrimaryKeySelective(major);

        return count>0 ? true:false;
    }

    @Override
    public boolean delete(int mid) {
        //通过主键进行删除,这里最多只会删除一条
        return majorMapper.deleteByPrimaryKey(mid)>0 ? true:false;
    }

    @Override
    public List<Major> getAll() {
        return majorMapper.selectAll();
    }

    @Override
    public List<Major> getList(Integer cid) {
        Example example  = new Example(Major.class);
        //sql过滤表达式
        Example.Criteria criteria = example.createCriteria();
        //参数1：实体类字段  参数2：值
        criteria.andEqualTo("cid",cid);
//        criteria.orLike("cid","%"+cid+"%");
        example.orderBy("mid").desc();
        List<Major> list = majorMapper.selectByExample(example);
        return list;
    }

    @Override
    public Page<Major> getAll(Major major, int pageNo, int limit) {
        Example example  = new Example(Major.class);
        //sql过滤表达式
        Example.Criteria criteria = example.createCriteria();
        //参数1：实体类字段  参数2：值
        if (major != null && major.getCid() != null && major.getCid() != 0 && major.getCid() != -1) {
            criteria.andEqualTo("cid", major.getCid());
        }
        //通过PageHelper分页
        PageHelper.startPage(pageNo,limit);
        List<Major> list = majorMapper.selectByExample(example);
        Page<Major> myPage = new Page(list);
        return myPage;
    }
}
