package com.qf.dao;

import com.qf.bean.Bills;

import java.util.List;
import java.util.Map;

public interface BillsMapper {

    public List<Bills> getbills(Map map);
    int deleteByPrimaryKey(Integer id);

    int insert(Bills record);

    int insertSelective(Bills record);

    Bills selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bills record);

    int updateByPrimaryKey(Bills record);
}