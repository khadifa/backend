package com.example.Aplication.repository;

import com.example.Aplication.model.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UniversityRepo extends JpaRepository<University,Integer> {
}
