package com.qq.persistence;

import com.qq.domian.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptDao extends JpaRepository<Dept,Integer> {
}
