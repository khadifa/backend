package com.example.Aplication.repository;

import com.example.Aplication.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DepartmentRepo extends JpaRepository<Department,Integer> {
}
