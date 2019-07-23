package com.qf.service;

import com.qf.bean.Billtype;

import java.util.List;

public interface BilltypeMapperService {
    public List<Billtype> findall();
    int deleteByPrimaryKey(Integer bid);

    int insert(Billtype record);

    int insertSelective(Billtype record);

    Billtype selectByPrimaryKey(Integer bid);

    int updateByPrimaryKeySelective(Billtype record);

    int updateByPrimaryKey(Billtype record);
}
