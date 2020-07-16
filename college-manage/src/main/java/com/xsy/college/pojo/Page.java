package com.xsy.college.pojo;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by Hunter on 2020-01-10.
 */
public class Page<T> extends PageInfo<T>{

    public Page(){}
    public Page(List list){
        super(list);
    }

    private int pageNo = 1;
    private int pageSize = 10;
    private int pageCount;
    private List<T> list;



    public Integer getPageNo() {
        return this.getPageNum();
    }


    public int getPageSize() {
        return super.getPageSize();
    }




    public int getPageCount() {
        return super.getPages();
    }


    public List<T> getList() {
        return super.getList();
    }

}
