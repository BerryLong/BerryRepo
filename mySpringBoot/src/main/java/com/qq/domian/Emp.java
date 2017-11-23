package com.qq.domian;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="tb_emp")
public class Emp implements Serializable {
    @Id
    @Column(name="eno")
    private Integer no;
    @Column(name="ename")
    private String name;
    @Column(name="esex")
    private boolean sex;
    @Column(name="ejob")
    private String job;
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="emgr")
    private Emp mgr;
    @Column(name="esal")
    private float sal;
    @Column(name="ehiredate")
    private Date hiredate;
    @Column(name="estatus")
    private boolean status;
    @Column(name="ephoto")
    private  String photo;
    @Column(name="etel")
    private String tel;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="dno")
    private Dept dept;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Emp getMgr() {
        return mgr;
    }

    public void setMgr(Emp mgr) {
        this.mgr = mgr;
    }

    public float getSal() {
        return sal;
    }

    public void setSal(float sal) {
        this.sal = sal;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}
