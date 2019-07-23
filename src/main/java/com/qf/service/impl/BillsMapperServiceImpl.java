package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.bean.Bills;
import com.qf.dao.BillsMapper;
import com.qf.service.BillsMapperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BillsMapperServiceImpl implements BillsMapperService {
    @Resource
    private BillsMapper billsMapper;

    @Override
    public PageInfo<Bills> getbills(int index, int size, int typeid, Date billtime,Date lasttime) {
        PageHelper.startPage(index,size);
        Map  map=new HashMap();
        map.put("typeid",typeid);
        map.put("billtime",billtime);
        map.put("lasttime",lasttime);
        List<Bills> billsList = billsMapper.getbills(map);
        PageInfo<Bills> pageInfo=new PageInfo<>(billsList);
        return pageInfo;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return billsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Bills record) {
        return 0;
    }

    @Override
    public int insertSelective(Bills record) {
        return billsMapper.insertSelective(record);
    }

    @Override
    public Bills selectByPrimaryKey(Integer id) {
        return billsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Bills record) {
        return billsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Bills record) {
        return 0;
    }
}
