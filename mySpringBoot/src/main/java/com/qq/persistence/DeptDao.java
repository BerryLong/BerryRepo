package com.qq.persistence;

import com.qq.domian.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestResource(path = "depts")
public interface DeptDao extends JpaRepository<Dept,Integer> {
}
