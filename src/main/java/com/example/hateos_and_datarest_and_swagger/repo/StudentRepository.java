package com.example.hateos_and_datarest_and_swagger.repo;

import com.example.hateos_and_datarest_and_swagger.entity.student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "student")
public interface StudentRepository extends JpaRepository<student, Integer> {
}