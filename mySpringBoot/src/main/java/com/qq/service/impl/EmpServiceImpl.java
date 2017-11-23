package com.qq.service.impl;

import com.qq.domian.Emp;
import com.qq.persistence.EmpDao;
import com.qq.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDao empDao;

    @Override
    public void deleteEmpByNo(Integer no) {
       empDao.delete(no);
    }

    @Override
    public Emp editEmp(Emp emp) {
        return empDao.saveAndFlush(emp);
    }

    @Override
    public Emp addNewEmp(Emp emp) {
        return empDao.save(emp);
    }

    @Override
    public Emp findEmpByNo(Integer no) {
        return empDao.findOne(no);
    }

    @Override
    public List<Emp> findEmps() {
        return empDao.findAll();
    }
}
