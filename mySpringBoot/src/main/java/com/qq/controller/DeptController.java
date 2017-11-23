package com.qq.controller;

import com.qq.domian.Dept;
import com.qq.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/depts")
    @ResponseBody
    public List<Dept> getDepts(){
        return deptService.listDepts();
    }
}
