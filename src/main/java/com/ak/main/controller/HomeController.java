package com.ak.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ak.main.entity.Employee;
import com.ak.main.service.EmpService;

@Controller
public class HomeController {
	@Autowired
	private EmpService empService;

	@GetMapping("/")
	public String openHomePage() {
		return "index";
	}

	@GetMapping("/openEmp")
	public String openEmpSavePage() {
		return "save_emp";
	}

	@GetMapping("/editEmp/{id}")
	public String openEditEmpPage(@PathVariable int id, Model model) {
		Employee emp = empService.getEmpById(id);
		if (emp != null) {
			model.addAttribute("emp", emp);
		}
		return "edit_emp";
	}

	@GetMapping("/employees")
	public String openAllEmpPage(Model m) {
		List<Employee> emp = empService.getAllEmp();
		m.addAttribute("empList", emp);
		return "employees";
	}

	@PostMapping("/saveEmp")
	public String saveEmpData(@ModelAttribute Employee employee, RedirectAttributes ra) {
		Employee emp = empService.saveEmp(employee);
		if (emp != null) {
			ra.addFlashAttribute("successMsg", "Employee Registration Successfully");
		} else {
			ra.addFlashAttribute("errorMsg", "Employee Registration Failed");
		}
		return "redirect:/openEmp";
	}

	@PostMapping("/updateEmpDtls")
	public String updateEmpData(@ModelAttribute Employee employee, RedirectAttributes ra) {
		Employee emp = empService.saveEmp(employee);
		if (emp != null) {
			ra.addFlashAttribute("successMsg", "Employee Update Successfully");
		} else {
			ra.addFlashAttribute("errorMsg", "Employee Update Failed");
		}
		return "redirect:/employees";
	}

	@GetMapping("/deleteEmp/{id}")
	public String deleteEmp(@PathVariable int id, RedirectAttributes ra) {

		boolean status = empService.deleteEmp(id);
		if (status) {
			ra.addFlashAttribute("successMsg", "Employee Delete Successfully");
		} else {
			ra.addFlashAttribute("errorMsg", "Employee Delete Failed");
		}
		return "redirect:/employees";
	}
}
