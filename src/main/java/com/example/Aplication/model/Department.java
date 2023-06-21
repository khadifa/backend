package com.example.Aplication.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data

public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int DeptId;
     private String DeptName;
     private int StdNo;
     private String StdPhone;

     @ManyToOne
     @JoinColumn(name = "Id")
     private Students students;

    public int getDeptId() {
        return DeptId;
    }

    public void setDeptId(int deptId) {
        DeptId = deptId;
    }

    public String getDeptName() {
        return DeptName;
    }

    public void setDeptName(String deptName) {
        DeptName = deptName;
    }

    public int getStdNo() {
        return StdNo;
    }

    public void setStdNo(int stdNo) {
        StdNo = stdNo;
    }

    public String getStdPhone() {
        return StdPhone;
    }

    public void setStdPhone(String stdPhone) {
        StdPhone = stdPhone;
    }
}
