package com.ak.main.service;

import java.util.List;

import com.ak.main.entity.Employee;

public interface EmpService {

	public Employee saveEmp(Employee employee);

	public List<Employee> getAllEmp();

	public Employee getEmpById(int id);

	public boolean deleteEmp(int id);

}
