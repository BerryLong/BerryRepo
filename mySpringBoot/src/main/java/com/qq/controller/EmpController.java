package com.qq.controller;

import com.qq.domian.Emp;
import com.qq.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping("/emps")
    public List<Emp> listEmps(){
        return empService.findEmps();
    }

    @GetMapping("/emps/{no}")
    public Emp findEmp(@PathVariable Integer no){
        return empService.findEmpByNo(no);
    }

    @DeleteMapping("/emps/{no}")
    public List<Emp> removeEmp(@PathVariable Integer no){
        empService.deleteEmpByNo(no);
        return empService.findEmps();
    }

    @PutMapping("/emps/{no}")
    public Emp editEmp(@PathVariable Integer no,Emp emp){
        return empService.editEmp(emp);
    }

    @PostMapping("/emps")
    public Emp addEmp(Emp emp){
        return empService.addNewEmp(emp);
    }
}
