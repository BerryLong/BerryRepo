package com.qfedu.service.impl;

import com.qfedu.domain.Dept;
import com.qfedu.persistence.DeptDao;
import com.qfedu.service.DeptService;
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
    public List<Dept> listAllDepts() {
        return deptDao.findAll();
    }

    @Override
    public Dept addNewDept(Dept dept) {
        return null;
    }

    @Override
    public Dept getByName(String name) {
        return deptDao.findByName(name);
    }
}
