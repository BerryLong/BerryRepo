package com.qq.service;

import com.qq.domian.Emp;

import java.util.List;

public interface EmpService {
    /**
     * 删除一个员工
     * @param no
     * @return
     */
    void deleteEmpByNo(Integer  no);
    /**
     * 编辑员工信息
     * @param emp
     * @return
     */
    Emp editEmp(Emp emp);

    /**
     * 添加新员工
     * @param emp 员工对象
     * @return 成功分会true 否则返回false
     */
    Emp addNewEmp(Emp emp);

    /**
     *按照编号查找员工信息
     * @param no 员工编号
     * @return 员工对象 or
     */
    Emp findEmpByNo(Integer no);

    /**
     * 查找员工是否有属下
     * @return 有属下返回true 否则返回false
     */
    List<Emp> findEmps();
}
