package com.example.Aplication.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data

public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int OrgId;
    private String OrgName;
    private String OrgNumber;
    private String OrgEmail;
    private String OrgAddress;


    @ManyToOne
    @JoinColumn(name = "DeptId")
    private Department department;

    public int getOrgId() {
        return OrgId;
    }

    public void setOrgId(int orgId) {
        OrgId = orgId;
    }

    public String getOrgName() {
        return OrgName;
    }

    public void setOrgName(String orgName) {
        OrgName = orgName;
    }

    public String getOrgNumber() {
        return OrgNumber;
    }

    public void setOrgNumber(String orgNumber) {
        OrgNumber = orgNumber;
    }

    public String getOrgEmail() {
        return OrgEmail;
    }

    public void setOrgEmail(String orgEmail) {
        OrgEmail = orgEmail;
    }

    public String getOrgAddress() {
        return OrgAddress;
    }

    public void setOrgAddress(String orgAddress) {
        OrgAddress = orgAddress;
    }
}
