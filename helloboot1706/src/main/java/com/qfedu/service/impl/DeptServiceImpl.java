package com.qfedu.service.impl;

import com.qfedu.domain.Dept;
import com.qfedu.persistence.DeptDao;
import com.qfedu.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return deptDao.save(dept);
    }

    @Override
    public Dept getDeptByNo(Integer no) {
        return deptDao.findOne(no);
    }

    @Override
    public Dept editDept(Dept dept) {
        return deptDao.saveAndFlush(dept);
    }

    @Override
    public void removeDeptByNo(Integer no) {
        deptDao.delete(no);
    }
}
