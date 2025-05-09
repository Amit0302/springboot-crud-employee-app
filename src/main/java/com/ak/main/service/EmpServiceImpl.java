package com.ak.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ak.main.entity.Employee;
import com.ak.main.repository.EmpRepository;

@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpRepository empRepository;

	@Override
	public Employee saveEmp(Employee employee) {

		return empRepository.save(employee);

	}

	@Override
	public List<Employee> getAllEmp() {

		return empRepository.findAll();
	}

	@Override
	public Employee getEmpById(int id) {

		return empRepository.findById(id).get();
	}

	@Override
	public boolean deleteEmp(int id) {
		Employee emp = empRepository.findById(id).get();
		if (emp != null) {
			empRepository.delete(emp);
			return true;
		}
		return false;
	}

}
