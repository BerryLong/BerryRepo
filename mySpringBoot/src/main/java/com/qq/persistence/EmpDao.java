package com.qq.persistence;

import com.qq.domian.Emp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpDao extends JpaRepository<Emp,Integer> {

}
