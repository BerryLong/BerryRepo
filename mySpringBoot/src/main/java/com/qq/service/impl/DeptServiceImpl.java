package com.qq.service.impl;

import com.qq.domian.Dept;
import com.qq.persistence.DeptDao;
import com.qq.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public List<Dept> listDepts() {
        return deptDao.findAll();
    }
}
