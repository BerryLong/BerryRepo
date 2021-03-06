package com.qfedu.persistence;

import com.qfedu.domain.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptDao extends JpaRepository<Dept, Integer>, DeptSearch {

    Dept findByName(String name);

}
