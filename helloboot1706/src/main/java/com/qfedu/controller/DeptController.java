package com.qfedu.controller;

import com.qfedu.domain.Dept;
import com.qfedu.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// RESTful架构
// REST - REpresentation State Transfer

@Controller
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping("/depts")
    @ResponseBody
    public List<Dept> showDepts() {
        return deptService.listAllDepts();
    }

    @GetMapping("/dept/{no}")
    public Dept getDept(@PathVariable Integer no) {
        return null;
    }

    @DeleteMapping("/dept/{no}")
    public Dept removeDept(@PathVariable Integer no) {
        return null;
    }

    @PutMapping("/dept/{no}")
    public Dept updateDept(Dept dept) {
        return null;
    }

    @GetMapping("/dept/{name}")
    @ResponseBody
    public Dept getDept(@PathVariable String name) {
        return deptService.getByName(name);
    }

    @PostMapping("/dept")
    @ResponseBody
    public Dept addDept(Dept dept) {
        return deptService.addNewDept(dept);
    }
}

