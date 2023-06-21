package com.example.Aplication.repository;

import com.example.Aplication.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface StudentsRepo extends JpaRepository <Students,Integer>{
}
