package com.qfedu.service;

import com.qfedu.domain.Dept;

import java.util.List;

public interface DeptService {

    List<Dept> listAllDepts();

    Dept addNewDept(Dept dept);

    Dept getDeptByNo(Integer no);

    Dept editDept(Dept dept);

    void removeDeptByNo(Integer no);
}
