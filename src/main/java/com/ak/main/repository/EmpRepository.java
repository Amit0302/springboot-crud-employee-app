package com.ak.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ak.main.entity.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer> {

}
