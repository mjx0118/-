package com.qf.service;

import com.github.pagehelper.PageInfo;
import com.qf.bean.Bills;

import java.util.Date;

public interface BillsMapperService {
    public PageInfo<Bills> getbills(int index, int size,  int typeid, Date billtime, Date lasttime);
    int deleteByPrimaryKey(Integer id);

    int insert(Bills record);

    int insertSelective(Bills record);

    Bills selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bills record);

    int updateByPrimaryKey(Bills record);
}
