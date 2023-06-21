package com.example.Aplication.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data

public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int UniId;
    private String UniName;
    private String Location;
    private String Email;

    @ManyToOne
    @JoinColumn(name = "Id")
    private Students students;

    public int getUniId() {
        return UniId;
    }

    public void setUniId(int uniId) {
        UniId = uniId;
    }

    public String getUniName() {
        return UniName;
    }

    public void setUniName(String uniName) {
        UniName = uniName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
