package com.example.Aplication.repository;

import com.example.Aplication.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface OrganizationRepo extends JpaRepository<Organization,Integer> {
}
