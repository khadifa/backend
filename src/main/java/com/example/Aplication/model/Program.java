package com.example.Aplication.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Program {
    private String ProName;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int ProId;

    @ManyToOne
    @JoinColumn(name = "Id")
    private Students students;

    public String getProName() {
        return ProName;
    }

    public void setProName(String proName) {
        ProName = proName;

    }

    public int getProId() {
        return ProId;
    }

    public void setProId(int proId) {
        ProId = proId;
    }
}
