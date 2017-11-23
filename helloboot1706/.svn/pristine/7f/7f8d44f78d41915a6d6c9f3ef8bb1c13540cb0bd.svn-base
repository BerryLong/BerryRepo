package com.qfedu.persistence.impl;

import com.qfedu.domain.Dept;
import com.qfedu.persistence.DeptSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class DeptDaoImpl implements DeptSearch {

   @Autowired
   private EntityManager entityManager;

    @Override
    public List<Dept> complicatedFoo() {
        return entityManager.createQuery("", Dept.class)
                .getResultList();
    }
}
