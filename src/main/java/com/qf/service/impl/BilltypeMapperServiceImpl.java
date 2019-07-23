package com.qf.service.impl;

import com.qf.bean.Billtype;
import com.qf.dao.BilltypeMapper;
import com.qf.service.BilltypeMapperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class BilltypeMapperServiceImpl  implements BilltypeMapperService {

    @Resource
    private BilltypeMapper billtypeMapper;
    @Override
    public List<Billtype> findall() {
        return billtypeMapper.findall();
    }

    @Override
    public int deleteByPrimaryKey(Integer bid) {
        return 0;
    }

    @Override
    public int insert(Billtype record) {
        return 0;
    }

    @Override
    public int insertSelective(Billtype record) {
        return 0;
    }

    @Override
    public Billtype selectByPrimaryKey(Integer bid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Billtype record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Billtype record) {
        return 0;
    }
}
