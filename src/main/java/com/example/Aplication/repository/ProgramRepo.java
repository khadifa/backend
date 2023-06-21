package com.example.Aplication.repository;


import com.example.Aplication.model.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProgramRepo extends JpaRepository<Program,Integer> {
}
